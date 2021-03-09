package MaratonaJava.Tdatas.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        String mascara ="'Joinville,' dd 'de' MMM 'de' yyyy 'as' HH:mm:ss z";
        SimpleDateFormat formatador = new SimpleDateFormat(mascara);
        System.out.println(formatador.format(c.getTime()));
    }
}
