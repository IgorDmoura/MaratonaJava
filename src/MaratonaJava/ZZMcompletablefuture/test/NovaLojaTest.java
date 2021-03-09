package MaratonaJava.ZZMcompletablefuture.test;

import MaratonaJava.ZZMcompletablefuture.classes.Desconto;
import MaratonaJava.ZZMcompletablefuture.classes.NovaLoja;
import MaratonaJava.ZZMcompletablefuture.classes.Orcamento;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class NovaLojaTest {
    public static void main(String[] args) {
        List<NovaLoja> lojas = NovaLoja.lojas();
//        lojas.stream().forEach(novaLoja -> System.out.println(novaLoja.getPreco()));
//        acharPrecos(lojas);
        final Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
//        acharPrecosAsync(lojas, executor);

        //thenaccept - após receber a informacao ele imprime
        long start = System.currentTimeMillis();
        CompletableFuture[] completableFutures = acharPrecosStream(lojas, executor) //Pega as pessoas
                .map(f -> f.thenAccept(s -> System.out.println(s+"(finalizado em " + (System.currentTimeMillis() - start) + " )"))) //Imprime elas
                .toArray(CompletableFuture[]::new); //Transforma elas em array
//        CompletableFuture.allOf(completableFutures).join(); //Pega tudo volta do thread do executor pro thread main e finaliza
        CompletableFuture.anyOf(completableFutures).join(); //Pega um dos resultados e finaliza
        System.out.println("Todas as lojas responderam em" + (System.currentTimeMillis() - start) + " ms");
    }

    private static List<String> acharPrecos(List<NovaLoja> lojas) {
        System.out.println("Stream Sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.stream()
                .map(NovaLoja::getPreco)
                .map(Orcamento::parse)
                .map(Desconto::calcularDesconto)
                .collect(Collectors.toList());

        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> acharPrecosAsync(List<NovaLoja> lojas, Executor executor) {
        System.out.println("Completabe Future Async");
        long start = System.currentTimeMillis();

        List<CompletableFuture<String>> completableFutures = lojas.stream()
                //Pegando o preço original de forma assincrona
                .map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
                //Transforma a string em um Orcamento no momento em que ele se torna disponivel
                .map(future -> future.thenApply(Orcamento::parse))
                //Compoe o primeiro future com mais uma chamada Ascyn para pegar os descontos
                //no momento que a primeira requisicao async estiver disponivel
                .map(future -> future.thenCompose(orcamento ->
                        CompletableFuture.supplyAsync(() -> Desconto.calcularDesconto(orcamento), executor)))
                .collect(Collectors.toList());

        //Espera todos os futures finalizarem para terem seus resultados extraidos
        List<String> collect = completableFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static Stream<CompletableFuture<String>> acharPrecosStream(List<NovaLoja> lojas, Executor executor) {
        System.out.println("Completabe Future Async Stream");
        long start = System.currentTimeMillis();
        Stream<CompletableFuture<String>> completableFutureStream = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
                .map(future -> future.thenApply(Orcamento::parse))
                .map(future -> future.thenCompose(orcamento ->
                        CompletableFuture.supplyAsync(
                                () -> Desconto.calcularDesconto(orcamento), executor)));
        System.out.println("Tempo total " + (System.currentTimeMillis() - start) + " ms");
        return completableFutureStream;
    }
}
