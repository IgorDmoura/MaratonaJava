package MaratonaJava.ZZEconcorrencia.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExercicioScheduleRunTest {
    private static final ScheduledExecutorService scheduleexecutorservice = Executors.newScheduledThreadPool(1);

    private static void grito(){
        final Runnable grito = new Runnable() {
            @Override
            public void run() {
                System.out.println("Batata - " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        };
        scheduleexecutorservice.scheduleAtFixedRate(grito,1,5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        grito();
    }
}
