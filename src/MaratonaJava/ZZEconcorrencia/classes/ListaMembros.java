package MaratonaJava.ZZEconcorrencia.classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListaMembros {
    private final Queue<String> emails = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition conditionLock = lock.newCondition();
    private boolean aberta = true;

    public int getEmailsPendentes() {
        lock.lock(); //Bloquea acesso a 1 thread por vez
        try {
            return this.emails.size(); //Executa comando
        } finally {
            lock.unlock(); //Desbloquea para a proxima thread entrar
        }
    }

    public boolean isAberta() {
        return aberta;
    }

    public String obterEmailMembro() {
        String email = null;
        try {
            lock.lock();
            while (this.emails.size() == 0) {
                if (!aberta) return null;
                System.out.println("Lista vazia, colocando a thread " + Thread.currentThread().getName() + " em modo wait");
                conditionLock.await(); //Libera o lock
            }
            email = this.emails.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return email;
    }

    public void adicionarEmailMembro(String email) {
        lock.lock();
        try {
            this.emails.add(email);
            System.out.println("Email adicionado na Lista");
            System.out.println("Notificando as Threads que estão em espera: " + Thread.currentThread().getName());
            conditionLock.signalAll();//Avisa todos da liberacao do lock
        } finally {
            lock.unlock();
        }

    }

    public void fecharLista() {
        System.out.println("Notificando todas as threads e fechando a lista");
        aberta = false;
        lock.lock();
        try{
        conditionLock.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
