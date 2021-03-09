package MaratonaJava.Oexception.test;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionTestAnotado {
    public static void main(String[] args) {
        criarArquivo();
    }

    public static void criarArquivo() {
        File file = new File("Teste2.txt"); // Objeto arquivo criado
        try {
            System.out.println("Arquivo criado?" + file.createNewFile()); // metodo que cria
            System.out.println("Arquivo criado"); // Essa linha so executa se criou
        } catch (IOException e) { // IOException - Erro que pode ocorrer sera pego e mostrado
            e.printStackTrace(); // Codigo que mostra o erro ao programador caso ele ocorra
        }
    }
}


//Try: Tenta executar o codigo - catch: caso nao de o try, ele pega o erro
        // e o printstacktrace mostra erro ao programador

        //Mp Checked diferente do runtime,pode por subclasse de excpetion no catch
        //desde que tenha uma excecao no try
        //Usar sempre o tipo mais especifico
