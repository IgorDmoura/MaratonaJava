package MaratonaJava.ZZEconcorrencia.test;

import java.util.concurrent.*;

public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        int count = ThreadLocalRandom.current().nextInt(1, 11); //Gera numero aleatorio
        for (int i = 0; i < count; i++) {
            System.out.println(Thread.currentThread().getName() + " executando...");

        }
        return "Trabalho Finalizado, o numero aleatorio eh:" + count;
    }

    public static void main(String[] args) {
        CallableTest ct = new CallableTest();
        ExecutorService executorService = Executors.newCachedThreadPool(); //Cria executor e faz variavel local
        Future<String> resultFuture = executorService.submit(ct); //Passa o callable pro executor
        try {
            String s = resultFuture.get();//Bloquea thread até que tenha o resultado e criar variavel local
            System.out.println(s); //Imprimi a variavel local que recebeu o resultado
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown(); //Para o sistema

    }
}


//Nao usar Wait, Notify ou NotifyAll no run ou call ao utilizar algum executor