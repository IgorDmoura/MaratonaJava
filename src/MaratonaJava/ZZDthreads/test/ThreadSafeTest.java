package MaratonaJava.ZZDthreads.test;

import java.util.LinkedList;
import java.util.List;

class ListaNome {
    private List<String> nomes = (new LinkedList<>());

    public synchronized void add(String nome) {
        nomes.add(nome);
    }

    public synchronized void removerPrimeiro() {
        if (nomes.size() > 0) {
            System.out.println(nomes.remove(0));
        }
    }
}

public class ThreadSafeTest {
    public static void main(String[] args) {
        ListaNome nome = new ListaNome();
        nome.add("Willian Suane");
        class RemovedordDeNomes extends Thread {
            public void run() {
                nome.removerPrimeiro();
            }
        }

        new RemovedordDeNomes().start();
        new RemovedordDeNomes().start();
    }

}
