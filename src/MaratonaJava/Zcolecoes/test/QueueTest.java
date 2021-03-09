package MaratonaJava.Zcolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        //O PriorityQueue e o Queue, ordenam tudo que for colocado dentro dessa coleção
        //O elemento adicionado tem que implementar a classe comparable

        Queue<String> queue  = new PriorityQueue<>();
        queue.add("C");
        queue.add("D");
        queue.add("A");
        queue.add("B");
        System.out.println(queue);

        //Métodos uteis
        //queue.remove - remove o primeiro elemento - Primeiro a entrar, primeiro a sair
        System.out.println(queue.remove());
        //queue.remove(objeto) - Remove objeto especifico - Nao é recomendado
        System.out.println(queue.remove("B"));
        //queue.peek - Pega primeiro elemento mas nao remove ele
        System.out.println(queue.peek());
        //queue.pool - Pega primeiro elemento e remove ele da coleção
        System.out.println(queue.poll());
        //queue.offer - Inserir elemento quando tem capacidade pré-definida, se passar limite retorna false
        //queue.size - Mostra tamanho do queue
        System.out.println(queue.size());
    }
}
