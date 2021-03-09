package MaratonaJava.ZZEconcorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        //Comportamentos do blocking queue
        //Filas limitadas - ArrayBlockingQueue, LinkedBlockingqueue e LinkedBlockdeck
        //Defini limite na criaçao dessas queue


        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        Thread t1 = new Thread(new removeFromQueue(bq));
        bq.put("Willian");
        System.out.println(bq.peek()); //Mostra primeiro valor sem remover
        System.out.println("Tentando colocar outro valor");
        t1.start();
        bq.put("DevDojo, o melhor dojo de TI do Brasil");
        System.out.println("Inserido o ultimo valor");
        //Como limite é 1, nao pode colocar outro valor no array

    }
    static class removeFromQueue implements Runnable{
        private BlockingQueue<String> bq;

        public removeFromQueue(BlockingQueue<String> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" entrando em espera pos 2s");
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Removendo o valor: " + bq.take()); //Take pega o primeiro e o remove
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
