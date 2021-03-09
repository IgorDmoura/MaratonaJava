package MaratonaJava.ZZEconcorrencia.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

//Classe imutavel - Todos Final é Thread safe
//Então nao tem problema de concorrencia

//O CopyOnWrite é parcialmente mutavel - o arraylist é mutavel

public class CopyOnWriteTest implements Runnable{
    //Imutavel: O objeto é apenas leitura
    private List<Integer> list = new CopyOnWriteArrayList<>();
    public CopyOnWriteTest() { //O CopyOnWrite não é recomendado se for fazer
        //mais alteracao do que utilizar na leitura, se alterar muito usando o
        //CopyOnWriteTest, nao vale a pena, perde desempenho
        for (int i = 0; i < 9000; i++) {
            list.add(i);
        }
    }

    @Override
    public void run() {
        Iterator<Integer> iterator = list.iterator();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(iterator.hasNext()){
            System.out.println(Thread.currentThread().getName()+" "+iterator.next());
        } //Não pode fazer remoção ou adicao usando iterator

    }

    public List<Integer> getList() {
        return list;
    }

    // [1,2,3] - Se apagar a posicao 1, o array aqui continua inteiro
    // [1,2] - e ele copia e faz outro com novo estado
    // [1] - Não é 100% Thread safe porque pode mecher na lista do array
    public static void main(String[] args) {
        CopyOnWriteTest ct = new CopyOnWriteTest();
        Thread t1 = new Thread(ct);
        Thread t2 = new Thread(ct);
        Thread removedor = new Thread(new RemoverMembros(ct.getList()));
        t1.start();
        t2.start();
        removedor.start();
    }

    private static class RemoverMembros implements Runnable{
        private List<Integer> list;

        public RemoverMembros(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 500; i++) {
                System.out.println(Thread.currentThread().getName()+" removeu " +list.remove(i));

            }

        }
    }

}
