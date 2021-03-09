package MaratonaJava.ZZNdatetime.test;

import MaratonaJava.ZZNdatetime.util.ObterProximoDiaUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateTimeAPITest4 {
    public static void main(String[] args) {

        //Trabalhando com localdate - TemporalAdjuster e TemporalAdjusters

        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        //Exemplo: ir para o proximo domingo - ir para o domingo anterior
        //Ir para o proximo dia, no mesmo dia da semana - se ja estiver no dia que foi marcado marca o dia atual

        date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        //Ir para proximo dia da semana ignorando se esta no dia que foi marcado, indo pro proximo

        date = date.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        //Voltar para a semana anterior no mesmo dia da semana marcado

        date = date.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        //Saber primeiro dia do mes
        date = date.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(date);
        //E o dia da semana do primeiro dia do mes
        System.out.println(date.getDayOfWeek());

        //Saber ultimo dia do mes
        date = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(date);
        //E o dia da semana do ultimo dia do mes
        System.out.println(date.getDayOfWeek());

        //Saber primeiro dia do proximo ano
        date = date.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(date);
        //E o dia da semana do primeiro dia do ano
        System.out.println(date.getDayOfWeek());

        //Usando método criado ObterProximoDiaUtil
        date = date.with(new ObterProximoDiaUtil());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());
        //Adicionando dias para testar o método novamente
        date = date.plusDays(3);
        System.out.println(date);
        System.out.println(date.getDayOfWeek());
        //Testando novamente
        date = date.with(new ObterProximoDiaUtil());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());
    }
}
