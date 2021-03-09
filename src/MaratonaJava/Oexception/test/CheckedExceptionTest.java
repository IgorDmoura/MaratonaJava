package MaratonaJava.Oexception.test;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionTest {
    public static void main(String[] args) {
        try {
            criarArquivo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void criarArquivo() throws IOException { // Joga a responsabilidade de tratar o codigo para quem chamou o metodo
        File file = new File("Teste2.txt");
        try {
            System.out.println("Arquivo criado?" + file.createNewFile());
            System.out.println("Arquivo criado");
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Joga a responsabilidade de tratar o codigo para quem chamou o metodo
        }
    }

}






