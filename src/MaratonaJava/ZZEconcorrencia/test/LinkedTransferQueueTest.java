package MaratonaJava.ZZEconcorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest {
    public static void main(String[] args) throws InterruptedException {
        //Mesmas caracteristicas que as outras classes do queue
        //Capacidade grande
        TransferQueue<String> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("Willian")); //Retorna true se foi adicionado
        //Ou lança um illegal argumetn exception
        tq.put("DevDojo"); //Bloquea se nao tiver capacidade
        tq.offer("Willian");//Retorna true se for adicionado ou false
        //se tiver cheio a capacidade, recomendado no lugar do add
        System.out.println(tq.offer("Willian",10, TimeUnit.MILLISECONDS));
        //Retorna true se for adicionado nessa janela de tempo
        //E falso se estiver cheia
//        tq.transfer("DevDojo");//Bloquea ate que esse elemento
        //Seja consumido por outra thread
        System.out.println(tq.tryTransfer("DevDojo")); //True se for consumido
        //por uma thread que ta esperando ou retorna falso se nao tive nenhuma
        //thread esperando para consumi-lo
        System.out.println(tq.tryTransfer("Devdojo",1,TimeUnit.SECONDS));
        //Espera esse tempo para ser consumido

        System.out.println(tq.remainingCapacity());

        System.out.println(tq.element()); //Pega primeiro valor sem remover
        //Ou lança excecao se for vazia
        System.out.println(tq.peek()); //Pega primeiro valor sem remover e retorna
        //nulo se for vazio
        System.out.println(tq.poll());//Pega primeiro valor e remove, retorna nulo
        //se tiver vazio
        System.out.println(tq.poll(10, TimeUnit.MILLISECONDS));
        //Remove primeiro valor e espera esse tempo para retornar nulo
        //Se estiver vazio
        System.out.println(tq.remove()); //Remove primeiro valor, e lança excecao
        //se estiver vazio
        System.out.println(tq.take()); //Remove primeiro valor ou bloquea até
        //que exista um elemento pronto

        //Criado no java 7
    }
}
