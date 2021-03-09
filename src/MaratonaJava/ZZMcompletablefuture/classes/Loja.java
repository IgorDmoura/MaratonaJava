package MaratonaJava.ZZMcompletablefuture.classes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja {
    private String nome;

    public Loja(String nome) {
        this.nome = nome;
    }

    public Loja() {
    }

    public double getPreco(){
        //Vai pegar o preco aonde judas perdeu as botas
        return calcularPreco();
    }

    public Future<Double> getPrecoAsync(){
        CompletableFuture<Double> precoFuturo = new CompletableFuture<>();
        new Thread(()->{
            try {
                precoFuturo.complete(calcularPreco());
            }catch (Exception e){
                precoFuturo.completeExceptionally(e); //Caso nao de, ele mostra a exception
            }
        }).start();
        return precoFuturo;
    }

    public Future<Double> getPrecoAsyncTunado(){
        return CompletableFuture.supplyAsync(this::calcularPreco);
        //Essa linha faz mesma coisa que as linhas do try catch do metodo anterior
        //Caso nao de pra calcular preço ela da a exception executor
    }

    private double calcularPreco(){
        delay();
//        System.out.println(1/0);
        return ThreadLocalRandom.current().nextDouble() * 100;
    }

    private static void delay(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getNome() {
        return nome;
    }
}
