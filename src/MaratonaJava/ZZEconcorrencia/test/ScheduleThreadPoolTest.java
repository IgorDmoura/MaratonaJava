package MaratonaJava.ZZEconcorrencia.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class ScheduleThreadPoolTest {
    private static final ScheduledExecutorService scheduleexecutorservice = Executors.newScheduledThreadPool(1);

    //Agendar tarefa para que executen de tanto em tanto tempo
    private static void beep() {
        final Runnable beeper = new Runnable() {
            @Override
            public void run() {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " beep");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //Inicia executando após 1 segundo e repete a cada 5 segundos
        //O tempo de sleep nao interfere, sera executado pelo tempo marcado no schedule
//        scheduleexecutorservice.scheduleAtFixedRate(beeper,1,5,TimeUnit.SECONDS);

        //O tempo de sleep é executado e só depois inicia o tempo do schedule
        ScheduledFuture<?> scheduledFuture = scheduleexecutorservice.scheduleWithFixedDelay(beeper, 1, 5, TimeUnit.SECONDS);

        //Executa e cancela após um tempo
        scheduleexecutorservice.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Cancelando");
                scheduledFuture.cancel(false);
                scheduleexecutorservice.shutdown();
            }
        }, 10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        beep();
    }
}








//Vai Executar uma vez no tempo determinado
//        scheduleexecutorservice.schedule(Runnable,24, TimeUnit.HOURS);