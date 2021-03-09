package MaratonaJava.Oexception.test;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionTest71 {
    public static void main(String[] args) {

        abrirArquivo();

    }

    public static void criarArquivo() throws IOException {
        File file = new File("Teste2.txt");
        try {
            System.out.println("Arquivo criado?" + file.createNewFile());
            System.out.println("Arquivo criado");
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void abrirArquivo() {
        try {
            System.out.println("Abrindo um arquivo");
            System.out.println("Executando a leitura do arquivo");
            throw new Exception();
            //System.out.println("Escrevendo no arquivo");
        } catch (Exception e) {
            System.out.println("Dentro do Catch");
            e.printStackTrace();
        }finally {
            System.out.println("Fechar o arquivo");
        }
    }


}






