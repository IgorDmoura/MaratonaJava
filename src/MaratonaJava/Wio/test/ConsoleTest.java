package MaratonaJava.Wio.test;

import java.io.Console;

public class ConsoleTest {
    public static void main(String[] args) {
        Console c = System.console();
        char[] pw = c.readPassword("%s" , "pw:" ); //Se usa Char pois pode apagar totalmente da memoria diferente do string
        for(char pass: pw){
            c.format("%c",pass);
        }
        c.format("\n");
        String texto;
        while (true) {
            texto = c.readLine("%s","Digite: "); //Aqui digita o texto
            c.format("Esse texto %s foi digitado", retorno(texto)); //O retorno que estiver depois da virgula, aparece no lugar do fmt (%s) no console
        }
    }
    public static String retorno(String arg1){
        return arg1;
    }
}
