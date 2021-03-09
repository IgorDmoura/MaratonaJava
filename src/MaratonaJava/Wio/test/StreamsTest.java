package MaratonaJava.Wio.test;

import java.io.*;

public class StreamsTest {
    public static void main(String[] args) {
        leitorTunado();

    }

    //Escrever no arquivo
    public static void gravador() {
        byte[] dados = {65, 66, 67, 68, 69, 70};
        try (FileOutputStream gravador = new FileOutputStream("pasta/stream.txt")) { //Cria arquivo
            gravador.write(dados); //Coloca oque ta no array no arquivo
            gravador.flush();
            System.out.println("Dados gravados com sucesso");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gravadorTunado() {
        byte[] dados = {65, 66, 67, 68, 69, 70};
        try (BufferedOutputStream gravadorbuffer = new BufferedOutputStream(new FileOutputStream("pasta/stream.txt"),4098)) { //Cria arquivo
            gravadorbuffer.write(dados); //Coloca oque ta no array no arquivo
            gravadorbuffer.flush();//Cospe tudo que tiver antes de fechar
            System.out.println("Dados gravados com sucesso");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leitor() {
        try (FileInputStream leitor = new FileInputStream("pasta/stream.txt")) {
            int leitura;
            while((leitura = leitor.read()) != -1){
                byte b = (byte) leitura;
                System.out.println(" " +b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leitorTunado() {
        try (BufferedInputStream leitorbuffer = new BufferedInputStream(new FileInputStream("pasta/stream.txt"),4098)) {
            int leiturabuffer;
            while((leiturabuffer = leitorbuffer.read()) != -1){
                byte b = (byte) leiturabuffer;
                System.out.println(" " +b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
