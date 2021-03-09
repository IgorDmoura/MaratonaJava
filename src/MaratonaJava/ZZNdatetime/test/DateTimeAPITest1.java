package MaratonaJava.ZZNdatetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class DateTimeAPITest1 {
    public static void main(String[] args) {

//        Formas antigas de ver a data
//        System.out.println(new Date()); - Date
//        System.out.println(Calendar.getInstance()); - Calendar

        //Formas de utlizar a nova API LocalDate
        LocalDate date = LocalDate.of(2017, Month.FEBRUARY, 15); //Criar uma data
        //Formas de imprimir
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getMonthValue()); //Pega o numero correspondente ao mes
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.lengthOfMonth()); //Mostra quantos dias tem o mes
        System.out.println(date.isLeapYear()); //Verifica se o ano é bissexto ou não

        //Pode imprimir com o get ou passando um temporalField:
        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));

        //Pegar data atual
        LocalDate now = LocalDate.now();
        System.out.println(date);
        System.out.println(now);

        //Detalhes sobre a data
        System.out.println(LocalDate.MAX); //Maior data possivel
        System.out.println(LocalDate.MIN); //Menor data possivel

        System.out.println("--------LocalDateTime--------");

        //Utilizando LocalTime pra mexer com horas

        //Criando e exibindo
        LocalTime time = LocalTime.of(22, 2, 15); //O indice vai de 0 a 23 horas
        System.out.println(time);

        //Formas de imprimir
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());

        //Detalhes sobre a hora
        System.out.println(time.MAX); //Hora máxima que pode usar
        System.out.println(time.MIN); //Hora mínima que pode usar

        System.out.println("--------Parsing--------");

        //Parse com Data - String para LocalDate
        LocalDate parseDate = LocalDate.parse("2017-02-15");
        System.out.println(parseDate);

        //Parse com Time - String para LocalTime
        LocalTime parseTime = LocalTime.parse("15:25:10");
        System.out.println(parseTime);

        System.out.println("--------LocalDateTime--------");

        //Utilizar LocalData e LocalTime ao mesmo tempo

        //Criar e imprimir um LocalDate Time
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        //Criando data mais especifica
        LocalDateTime ldt1 = LocalDateTime.of(2017,8,6,8,35,33);
        System.out.println(ldt1);

        //Colocar Hora em um Date
        LocalDateTime ldt3 = date.atTime(10,20,20);
        System.out.println(ldt3);

        //Colocando a hora atual em um date
        LocalDateTime ldt4 = date.atTime(LocalTime.now());
        System.out.println(ldt4);

        //Colocando uma hora existente (LocalTime) em um LocalDate
        LocalDateTime ldt5 = date.atTime(time);

        //Agora ao contrario, adicionado um Time em um Date:
        LocalDateTime ldt6 = time.atDate(date);
        System.out.println(ldt6);
        //Tambem poder adicionar ao time o date atual:
        LocalDateTime ldt7 = time.atDate(LocalDate.now());
        System.out.println(ldt7);
        //Nesse caso nao pode definir uma nova data escrevendo, apenas usando um data existente



    }
}
