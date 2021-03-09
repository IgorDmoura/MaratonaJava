package MaratonaJava.ZZNdatetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeAPITest5 {
    public static void main(String[] args) {

        //Formatação e parse
        LocalDate date = LocalDate.now();

        //Transformando um localdate em um string - Format
        //Classe que define a formatação: DateTimeFormatter

        //Tipos de formatação (Data pra string)
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(s1);

        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        System.out.println(s2);

        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s3);

        //Transformando um string em um localdate - Parse
        String s4 = "20170221"; //O formatador nao aceita string desse tipo apenas do tipo do s5 abaixo
        //Porem se sobrecarregar o parse, falando qual tipo de data ta na string ele aceita
        String s5 = "2017-02-21";

        LocalDate parse = LocalDate.parse(s5);
        System.out.println(parse);

        //Testando o parse sobrecarregado dito acima
        LocalDate parse2 = LocalDate.parse(s4, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse2);

        //Utilizando a formatacao no LocalDateTime

        //Transformando o dateTime em um string
        LocalDateTime dateTime = LocalDateTime.now();
        String s6 = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s6);

        //Transformando o string em um dateTime
        LocalDateTime parse1 = LocalDateTime.parse("2021-02-12T22:12:44.2054499");
        System.out.println(parse1);

        //Formato brasileiro: dd/MM/yyyy
        //Formato americano: MM/dd/yyyy
        //Formato Japones: yyyy/MM/dd

        //Mudar para um formato especifico que voce quiser:
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Esse formatter criado serve tanto pro format quando pro parse

        //Usando no Format (De Date pra String)
        String formatBR = LocalDate.now().format(formatterBR);
        System.out.println(formatBR);

        //Usando no Parse (De String pra Date)
        String dataBRString = "01/12/2017";
        LocalDate parse3 = LocalDate.parse(dataBRString, formatterBR);
        System.out.println(parse3);

        //Pode criar um formatador especifico pra um local
        DateTimeFormatter formatterFR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.FRANCE);
        String formatFR = LocalDate.now().format(formatterFR);
        System.out.println(formatFR);
        //Usando o formatador da frança no parse
        LocalDate parse4 = LocalDate.parse("12.février.2021",formatterFR);
        System.out.println(parse4);


    }
}
