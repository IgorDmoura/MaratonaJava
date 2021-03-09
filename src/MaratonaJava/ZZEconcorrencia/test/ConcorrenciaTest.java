package MaratonaJava.ZZEconcorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Contador{
    private int count; //Nao garante total execucao
    private AtomicInteger atomicInteger = new AtomicInteger(); //Garante Execucao
    private Lock lock = new ReentrantLock(); //Diferente do syncronized, a thread pode ser interrompida no meio da execucao

    //Quando usar o syncronized: Quando tudo funciona com syncronized use-o
    //Quando usar o lock: Quando precisa usar o wait ou reentrylock ou escalar
    //Usuarios avançados usam coisas mais simples

    public void increment(){
        lock.lock(); //Pega lock e executa ação
        try{
        count++;
        atomicInteger.getAndIncrement();
        }finally{
            lock.unlock(); //Libera lock
        }
    }

    public int getCount() {
        return count;
    }

    public int getAtomicInteger() {
        return atomicInteger.intValue();
    }
}

class IncrementadorThread extends Thread{
    private Contador contador;

    public IncrementadorThread(Contador contador){
        this.contador = contador;
    }

    public void run(){
        for (int i = 0; i < 10000; i++) {
            contador.increment();
        }
    }
}
public class ConcorrenciaTest {
    public static void main(String[] args) throws InterruptedException {
        Contador c = new Contador();
        IncrementadorThread it1 = new IncrementadorThread(c);
        IncrementadorThread it2 = new IncrementadorThread(c);
        it1.start();
        it2.start();
        it1.join();
        it2.join();
        System.out.println(c.getCount());
        System.out.println(c.getAtomicInteger());
    }
}
//Atomic Integer - Mais rapido que syncronized