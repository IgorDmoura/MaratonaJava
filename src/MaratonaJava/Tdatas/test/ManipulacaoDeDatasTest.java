package MaratonaJava.Tdatas.test;

import java.util.Calendar;
import java.util.Date;

public class ManipulacaoDeDatasTest {
    public static void main(String[] args) {
        Date date = new Date(); //Mostra a Data Atual
        System.out.println(date);

        Calendar c = Calendar.getInstance(); // cria objetos abstratos
        c.setTime(date);
        if(Calendar.SUNDAY == c.getFirstDayOfWeek()){
            System.out.println("Domingo é o primeiro dia da semana");
        }
        System.out.println(c.get(Calendar.DAY_OF_MONTH));//Mostra o dia do mes
        System.out.println(c.get(Calendar.DAY_OF_YEAR));//Mostra dia do ano
        System.out.println(c.get(Calendar.DAY_OF_WEEK));//Mostra dia da semana
        c.add(Calendar.HOUR, 24); //Adiciona hora, dia, ano
        c.roll(Calendar.YEAR, 2);//Adiciona só mudando o que foi marcado
        Date date2 = c.getTime();

        System.out.println(date2);

        //NumberFormat, Locale, Calendar, Date, DateFormat


    }
}
