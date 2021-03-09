package MaratonaJava.ZZNdatetime.test;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class DateTimeAPITest6 {
    public static void main(String[] args) {

        //TimeZone

        //Mostrar todas as zonas
        for (Map.Entry<String, String> zonas : ZoneId.SHORT_IDS.entrySet()){
            System.out.println(zonas.getKey() + " " + zonas.getValue());
        }

        System.out.println("-------------------------");

        //Mostra o ID do sistema
        System.out.println(ZoneId.systemDefault());

        //Mostra o ID/Zona de um pais
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println(tokyoZone);

        //Criando um date time
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        //Adicionando esse datetime a zona de toquio
        ZonedDateTime zonedDateTime = dateTime.atZone(tokyoZone);
        System.out.println(zonedDateTime);

        //Usando Instant - Instant se refere a hora UTC
        Instant instant = Instant.now();
        System.out.println(instant);
        //Adicionado a zona de toquio ao instant
        ZonedDateTime zonedDateTime1 = instant.atZone(tokyoZone);
        System.out.println(zonedDateTime1);

        //Minimo e maximo possivel de fuso horario
        System.out.println(ZoneOffset.MIN);
        System.out.println(ZoneOffset.MAX);

        //Achando um horario de algum lugar definindo o valor do fuso horario
        ZoneOffset manausOffSet = ZoneOffset.of("-04:00");
        //Criando um datetime e colocando o horario criado de manaus
        LocalDateTime dateTime1 = LocalDateTime.now();
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime1, manausOffSet);
        System.out.println(offsetDateTime);
        //Outra forma de passar o offset pro datetime
        OffsetDateTime offsetDateTime2 = dateTime1.atOffset(manausOffSet);
        System.out.println(offsetDateTime2);

        //Usando Instant no offset
        Instant instant1 = Instant.now();
        System.out.println(instant1.atOffset(manausOffSet));

        //Usar outro calendarios
        //Japonesa
        JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
        System.out.println(japaneseDate);

        //Mudar era do calendario do Japao (Baseado no Imperador)
        LocalDate antigamente = LocalDate.of(1900, 2, 1);
        System.out.println(JapaneseDate.from(antigamente));


    }
}
