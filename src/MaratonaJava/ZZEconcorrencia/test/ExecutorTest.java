package MaratonaJava.ZZEconcorrencia.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadTrabalhadoraExecutor implements Runnable{
    private String num;

    public ThreadTrabalhadoraExecutor(String num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " iniciou" + num);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " Finalizou");
    }

}
public class ExecutorTest { //Framework Executors
    //Principal conceito é que a submissao das tarefas é desacoplado da execução
    //das tarefas
    //Executor executa o método run igual uma thread, mas de uma forma diferente
    //Pode startar threads de formas diferentes
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
//        ExecutorService executorService = Executors.newFixedThreadPool(4);//Numero de thread pra executa a tarefa
//        ExecutorService executorService = Executors.newCachedThreadPool();//Criar novas threads conform necssario
        //Se as threads ficarem ociosas por 60s sao removidas do pool de threads
        ExecutorService executorService = Executors.newSingleThreadExecutor();//Usa apenas uma thread para realizar as tarefas
        //E as tarefas que nao podem ser executadas agora, sao colocadas em uma fila queue
        //Nesse tipo nao pode mudar os threas permitidos pois é unico
//        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
//        threadPoolExecutor.setCorePoolSize(3); //Muda threads permitidos
        //Colocar valor até 2 vezes a quantidade de procesadores do pc
        //Se tem 2 processadores, limite threads 4
        //Criar 4 threads:
        executorService.execute(new ThreadTrabalhadoraExecutor("1"));
        executorService.execute(new ThreadTrabalhadoraExecutor("2"));
        executorService.execute(new ThreadTrabalhadoraExecutor("3"));
        executorService.execute(new ThreadTrabalhadoraExecutor("4"));
        executorService.execute(new ThreadTrabalhadoraExecutor("5"));
        executorService.execute(new ThreadTrabalhadoraExecutor("6"));
        //O numero de threads sempre sera o marcado, ele so reutiliza as mesmas
        executorService.shutdown();//Finaliza os executors
        while(!executorService.isTerminated()){}
        System.out.println(executorService.isTerminated());
        System.out.println("Finalizado");

    }
}
