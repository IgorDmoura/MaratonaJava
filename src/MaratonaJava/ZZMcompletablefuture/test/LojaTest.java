package MaratonaJava.ZZMcompletablefuture.test;

import MaratonaJava.ZZMcompletablefuture.classes.Loja;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class LojaTest {
    public static void main(String[] args) {

        //Programacao Sincrona - Executa os metodos e enquanto nao ter retorno fica com thread bloqueada e ociosa
        Loja americanas = new Loja();
        Loja casasBahia = new Loja();
        Loja bestBuy = new Loja();
        Loja wallmart = new Loja();
//        long start = System.currentTimeMillis();
//        System.out.println(americanas.getPreco());
//        System.out.println(casasBahia.getPreco());
//        System.out.println(bestBuy.getPreco());
//        System.out.println(wallmart.getPreco());
//        System.out.println(System.currentTimeMillis() - start + " ms");

        //Programacao Asincrona
        long start = System.currentTimeMillis();
        Future<Double> precoAsync = americanas.getPrecoAsyncTunado(); //Pega dados pra usar no futuro
        Future<Double> precoAsync1 = casasBahia.getPrecoAsyncTunado();
        Future<Double> precoAsync2 = bestBuy.getPrecoAsyncTunado();
        Future<Double> precoAsync3 = wallmart.getPrecoAsyncTunado();
        long end = System.currentTimeMillis();
        System.out.println("Tempo de invocacao: " + (end - start) + " ms"); //Continua executando, mostra mensagem
        enrolando();
        try {
            System.out.println("Americanas " +precoAsync.get()); //Mostra resultado
            System.out.println("casasBahia " +precoAsync1.get()); //O tempo faz ele ser executado em 3 segundos
            System.out.println("bestBuy " +precoAsync2.get()); //Se nao tive resposta em 3s da um timeoutexception
            System.out.println("wallmart " +precoAsync3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Tempo que levou para pegar o resultado " + (System.currentTimeMillis() - start)+ " ms");

    }

    private static void enrolando() {
        long soma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            soma += i;
        }
        System.out.println(soma);
    }
}
