package MaratonaJava.Wio.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReaderTest {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt");
        try {
            FileWriter fw = new FileWriter(file); //Ja cria o arquivo automaticamente
            fw.write("Escrevendo uma mensagem no arquivo \nE pulando uma linha");
            fw.flush();
            fw.close();

            FileReader fr = new FileReader(file);
            char[] in = new char[500];
            int size = fr.read(in);
            System.out.println("tamanho: " + size);
            for(char c: in){
                System.out.print(c);
            }
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
