package MaratonaJava.Tdatas.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
        //ISO 639 - pt - Portugues - BR - Brasil, en - Ingles - US - Estados Unidos;
        Locale LocItalia = new Locale("it","IT");
        Locale LocIndia = new Locale("hi","IN");
        Locale LocJapao = new Locale("ja"); // cria local 
        Calendar c = Calendar.getInstance();
        c.set(2015,4,4); //seta uma deta pro calendar
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,LocItalia); //cria objeto dateformat
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL,LocIndia);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL,LocJapao);
        System.out.println("Italia: " +df.format(c.getTime())); //get time transforma date em calendar
        System.out.println("India: " + df1.format(c.getTime()));
        System.out.println("Japao: " + df2.format(c.getTime()));

        System.out.println(LocItalia.getDisplayLanguage());//Idioma do local
        System.out.println(LocJapao.getDisplayLanguage());
        System.out.println(LocJapao.getDisplayLanguage(LocJapao));//idioma no idioma
        System.out.println(LocItalia.getDisplayLanguage(LocIndia));//Italino em indiano
        System.out.println(LocIndia.getDisplayCountry());//Diz nome do país
        System.out.println(LocIndia.getDisplayCountry(LocItalia));//nome do pais no idioma selecionado

    }
}
