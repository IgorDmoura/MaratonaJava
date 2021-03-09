package MaratonaJava.ZZNdatetime.test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITest2 {
    public static void main(String[] args) {

        //Instant - Ela representa um ponto no tempo utlizando nanosegundos
        Instant instant = Instant.now();
        System.out.println(instant);

        //Seria impossivel guardar em long o nanos segundos desde 1970
        //Entao foi criado 2 variaveis
        System.out.println(instant.getEpochSecond()); //Segundo atual desde 1970
        System.out.println(instant.getNano()); //Tempo em nanos segundos do ultimo segundo - Max: 999.999.999

        //Adicionando segundos a um instant - 1970 + o tempo adicionado
        System.out.println(Instant.ofEpochSecond(3));
        //Da pra ajustar o nanosegundos do ofepochsecond, sobrecarregando o método com os mesmos
        System.out.println(Instant.ofEpochSecond(3,90_000_000));
        System.out.println(Instant.ofEpochSecond(2,1_000_000_000));
        System.out.println(Instant.ofEpochSecond(4,-1_000_000_000));

        System.out.println("---------DURATION---------");
        //Duration
        //Pegar intervalos de data
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.of(2017,1,1,23,0,0);

        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.of(5,0,0);

        //Duration - Intervalo entre data
        Duration d1 = Duration.between(dt1,dt2);
        System.out.println(d1);

        //Duration - Intervalo entre time
        Duration d2 = Duration.between(time1,time2);
        System.out.println(d2);

        //Duration - Instant
        Duration d3 = Duration.between(Instant.now(),Instant.now().plusSeconds(1000));
        //PlusSeconds - Adiciona alguns segundos ao instant
        System.out.println(d3);

        //Nao pode usar LocalDate no Instant
        //Nao pode misturar LocalDateTime com LocalTime
//        Duration d4 = Duration.between(dt2,time2);
//        Duration d5 = Duration.between(LocalDate.now(),LocalDate.now().plusDays(20));

        //Comparar LocalDateTime com LocalTime
        Duration d6 = Duration.between(dt2,time2.atDate(dt2.toLocalDate()));

        //Criar duration especificando minutes, horas e dias e outros exceto meses
        Duration d7 = Duration.ofMinutes(3);
        Duration d8 = Duration.ofDays(10);
        System.out.println(d7);
        System.out.println(d8);


        System.out.println("---------PERIOD---------");

        //Verificar intervalo entre duas datas
        Period p1 = Period.between(dt1.toLocalDate(),dt2.toLocalDate());
        System.out.println(p1);

        //Criando um Period
        Period p2 = Period.ofDays(10);
        Period p3 = Period.ofWeeks(58);
        System.out.println(p2);
        System.out.println(p3);

        //Transformar semanas em meses
//        System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(p3.getDays())).getMonths());
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.until(now.plusDays(p3.getDays()),ChronoUnit.MONTHS));
        //Until significa até - ou seja ele contou do dia atual até o dia marcado

        System.out.println("---------CHRONOUNIT---------");
        //Pegar intervalo entre duas datas
        LocalDateTime aniversario = LocalDateTime.of(1975,8,23,12,0,0);

        //Imprimindo intervalos com ChronoUnit
        System.out.println(ChronoUnit.DAYS.between(aniversario,now));
        System.out.println(ChronoUnit.WEEKS.between(aniversario,now));
        System.out.println(ChronoUnit.MONTHS.between(aniversario,now));
        System.out.println(ChronoUnit.YEARS.between(aniversario,now));






    }
}
