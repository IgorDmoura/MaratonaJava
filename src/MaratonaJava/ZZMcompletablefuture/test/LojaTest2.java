package MaratonaJava.ZZMcompletablefuture.test;

import MaratonaJava.ZZMcompletablefuture.classes.Loja;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class LojaTest2 {
    public static void main(String[] args) {
        List<Loja> lojas = asList(
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("bestbuy"),
                new Loja("americanas"),
                new Loja("wallmart"));
//        acharPrecos(lojas);
        acharPrecos2(lojas);
//        acharPrecos3(lojas);
        acharPrecos4(lojas);
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(lojas.size());

        //Numero de threads = Ncpu * Ucpu* (1+W/C)
        //Ncpu = numero de cores disponiveis
        //Ucpu = quantidade de utlizacao da cpu (0-1) - Se quise utilizar 50% é 0,5 se for 100% é 1
        // W/C = wait time e compute time %
        // N threads = 8 * 1 * (1+99) = 800 threads
        final Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100),r->{
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
        acharPrecos4(lojas,executor);

    }

    private static List<String> acharPrecos(List<Loja> lojas) {
        System.out.println("Stream Sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.stream().map(loja -> String.format("%s o preço h: %.2f", loja.getNome(), loja.getPreco()))
                .collect(Collectors.toList());
        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> acharPrecos2(List<Loja> lojas) {
        System.out.println("Stream Paralelo");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.parallelStream()
                .map(loja -> String.format("%s o preço h: %.2f", loja.getNome(), loja.getPreco()))
                .collect(Collectors.toList());
        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> acharPrecos3(List<Loja> lojas) {
        System.out.println("Completable Future Sequencial");
        long start = System.currentTimeMillis();

        List<String> collect = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preço h: %.2f", loja.getNome(), loja.getPreco())
                )).map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println("Tempo de invocacao " + (System.currentTimeMillis() - start) + " ms");

        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> acharPrecos4(List<Loja> lojas) {
        System.out.println("Completable Future");
        long start = System.currentTimeMillis();

        List<CompletableFuture<String>> precoFuturo = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preço h: %.2f", loja.getNome(), loja.getPreco())
                ))
                .collect(Collectors.toList());


        System.out.println("Tempo de invocacao " + (System.currentTimeMillis() - start) + " ms");

        List<String> collect = precoFuturo.stream().map(CompletableFuture::join).collect(Collectors.toList());

        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");

        System.out.println(collect);
        return collect;
    }

    private static List<String> acharPrecos4(List<Loja> lojas, Executor executor) {
        System.out.println("Completable Future");
        long start = System.currentTimeMillis();

        List<CompletableFuture<String>> precoFuturo = lojas.stream()
                .map(loja -> CompletableFuture
                        .supplyAsync(() -> String.format("%s o preço h: %.2f",
                                loja.getNome(), loja.getPreco()),executor
                ))
                .collect(Collectors.toList());


        System.out.println("Tempo de invocacao " + (System.currentTimeMillis() - start) + " ms");

        List<String> collect = precoFuturo.stream().map(CompletableFuture::join).collect(Collectors.toList());

        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");

        System.out.println(collect);
        return collect;
    }

}
