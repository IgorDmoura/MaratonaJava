package MaratonaJava.ZZDthreads.test;

public class ThreadTest {
    //Daemon - Se for daemon a jvm pode parar sem problemas
    //Exemplo: Garbage Collection
    //User - Uma JVM só finaliza sua execucao após todas as threads user serem executadas


    static class ThreadExemplo extends Thread{
        private char c;
        public ThreadExemplo(char c){
            this.c = c;
        }
        @Override
        public void run(){
            System.out.println("Thread executando: " + Thread.currentThread().getName());
            for (int i = 0; i < 1000; i++) {
                System.out.print(c);
                if(i % 100 == 0){
                    System.out.println();
                }
            }
        }
    }


    static class ThreadExemploRunnable implements Runnable{

        private char c;

        public ThreadExemploRunnable(char c){
            this.c = c;
        }

        @Override
        public void run() {
            System.out.println("Thread executando: " + Thread.currentThread().getName());
            for (int i = 0; i < 1000; i++) {
                System.out.print(c);
                if(i % 100 == 0){
                    System.out.println();
                }

//                if (!Thread.currentThread().getName().equals("T4"))
                Thread.yield(); // Faz a thread que esta em execucao voltar para estado runnable
                //E dar chance para thread como mesma prioridade voltar para running





               try {
                    Thread.sleep(200); //Defini um tempo a cada execucao do thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
//        ThreadExemplo t1 = new ThreadExemplo('A');
//        ThreadExemplo t2 = new ThreadExemplo('B');
//        ThreadExemplo t3 = new ThreadExemplo('C');
//        ThreadExemplo t4 = new ThreadExemplo('D');
        Thread t1 = new Thread(new ThreadExemploRunnable('A'),"T1");
        Thread t2 = new Thread(new ThreadExemploRunnable('B'),"T2");
        Thread t3 = new Thread(new ThreadExemploRunnable('C'),"T3");
        Thread t4 = new Thread(new ThreadExemploRunnable('D'),"T4");
        t4.setPriority(Thread.MAX_PRIORITY); //Tem mais chances de ser executada ao voltar
        t1.start();
        t1.join(); //A trade que vai executar o t1(main) espera t1 executar pra só depois executar proximas linhas
        t2.start();
//        t3.start();
//        t4.start();



    }
}

//New - Criar thread (Nova, porem nao viva)
//t1.start - ela esta pronta pra ser executada - runa
//Running - Seleciona thread e começa realmente executar método run - vira processo
//Porem a thread nao fica no running nao fica sempre no running ela pode estar
//Dormindo ou bloqueada - Waiting blocking
//Exemplo: Carregamento de arquivo pesado, thread fica bloqueada ate o mesmo carregar
//Depois que sai do waiting blocking vai pro runnable pra dps ir pro running
//Uma thread nao pode pedir para outra thread ser bloqueada
//A propria thread decide por si mesma
//E ao morrer a thread, ela vai pro dead, ela foi completada
//Uma thread ao morrer nao pode ser executada novamente

//Ao criar thread ela está no new
//Ao dar o start ela está no runnable
//Quando se decide executar ela vai pro running
//Se executou tudo ela vai pra dead
//Ou ela pode ficar em bloqueada em esperar - sleeping
//E se for bloqueada depois que desbloquear volta pra runnable

