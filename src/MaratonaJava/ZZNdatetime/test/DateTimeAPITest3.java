package MaratonaJava.ZZNdatetime.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITest3 {
    public static void main(String[] args) {

        //Manipular uma data
        LocalDate localDate = LocalDate.of(2017, Month.FEBRUARY,25);
        System.out.println(localDate);

        //Mudar ano de uma data
        localDate = localDate.withYear(2020);
        System.out.println(localDate);
        //Pelo fato da classe ser ThreadSafe ao mudar um valor ele cria outro e nao altera o original

        //Mudar mes de uma data
        localDate.withMonth(Month.AUGUST.getValue());
        System.out.println(localDate);

        //Mudar dia do mes
        localDate = localDate.withDayOfMonth(20);
        System.out.println(localDate);

        //Outra forma de fazer isso tudo usando Temporal Field:
        localDate = localDate.with(ChronoField.DAY_OF_MONTH,15);
        localDate = localDate.with(ChronoField.MONTH_OF_YEAR,5);
        System.out.println(localDate);

        //Adicionar meses a mais em um mes - Plus serve pra adicionar seja mes, dia etc...
        localDate = localDate.plusMonths(2);
        System.out.println(localDate);
        //Outra forma usando TemporalUnit:
        localDate = localDate.plus(2, ChronoUnit.MONTHS);
        System.out.println(localDate);

        //Removendo dias, meses, anos etc do localdate
        localDate = localDate.minusDays(20);
        System.out.println(localDate);
        localDate = localDate.minusWeeks(1);
        System.out.println(localDate);
        localDate = localDate.minusYears(1);
        System.out.println(localDate);

        System.out.println("-----------TIME-----------");

        //Manipular um time
        LocalTime time = LocalTime.now();
        System.out.println(time);

        //Trocar hora, minutos etc...
        time = time.withHour(10);
        System.out.println(time);
        time= time.withMinute(15);
        System.out.println(time);

        //Adicionar tempo
        time = time.plusHours(5);
        System.out.println(time);

        //Remover tempo
        time = time.minusHours(5);
        System.out.println(time);












    }
}
