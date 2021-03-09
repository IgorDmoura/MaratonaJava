package MaratonaJava.Tdatas.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {
    public static void main(String[] args) {
        float valor = 212.4567F;
        Locale LocJP = new Locale("jp");
        //Só pode usar new em classes abstratas se criar um array
        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getInstance();
        nfa[1] = NumberFormat.getInstance(LocJP);
        nfa[2] = NumberFormat.getCurrencyInstance();
        nfa[3] = NumberFormat.getCurrencyInstance(LocJP);

        for(NumberFormat nf : nfa){
            System.out.println(nf.format(valor));
        }

        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println(nf.getMaximumFractionDigits());//Mostra maximo de digitos
        nf.setMaximumFractionDigits(1);// Defini maximo de digitos apos virgula
        System.out.println(nf.format(valor));//mostra o valor
        String valorString = "212.565";
        try {
            System.out.println(nf.parse(valorString)); //Resultou 2124567, deveria ser 212,4567
            nf.setParseIntegerOnly(true);
            System.out.println(nf.parse(valorString)); //Resultou 2124567, deveria ser 212
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
