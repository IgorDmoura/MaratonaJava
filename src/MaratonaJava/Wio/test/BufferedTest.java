package MaratonaJava.Wio.test;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));
             BufferedReader br = new BufferedReader(new FileReader(file))) {
            bw.write("Escrevendo uma mensagem no arquivo");
            bw.newLine(); //Pular Linha
            bw.write("E pulando uma linha");
            bw.flush();
            String s; //Cria variavel nula, pois quando o readline termina texto, retorna um null
            while ((s = br.readLine()) != null) { //Enquanto nao for null pegue o texto
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            FileWriter fw = new FileWriter(file); //Ja cria o arquivo automaticamente
//            BufferedWriter bw = new BufferedWriter(fw);
//
//            bw.write("Escrevendo uma mensagem no arquivo");
//            bw.newLine(); //Pular Linha
//            bw.write("E pulando uma linha");
//            bw.flush();
//            bw.close();
//
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String s = null; //Cria variavel nula, pois quando o readline termina texto, retorna um null
//            while((s=br.readLine()) != null){ //Enquanto nao for null pegue o texto
//                System.out.println(s);
//            }
//            br.close(); //Fechando o mais externo ele fecha os mais interno
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
