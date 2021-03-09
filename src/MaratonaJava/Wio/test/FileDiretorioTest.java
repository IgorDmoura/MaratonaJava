package MaratonaJava.Wio.test;

import java.io.File;
import java.io.IOException;

public class FileDiretorioTest {
    public static void main(String[] args) throws IOException {
//        File diretorio = new File("folder"); //Cria um arquivo
//        boolean mkdir = diretorio.mkdir(); //Cria um diretorio
//        System.out.println("Diretório criado " + mkdir);
//        File arquivo = new File(diretorio,"Arquivo.txt");
//        boolean newFile = arquivo.createNewFile();
//        System.out.println("Arquivo criado " + newFile);
//        File arquivoNovoNome = new File(diretorio,"arquivo.txt"); //Renomear arquivo
//        boolean renamed = arquivo.renameTo(arquivoNovoNome); // renomear
//        System.out.println("Renomeado " + renamed); // verifica se foi renomeado
//        File diretorioRenomeado = new File("folder3");
//        boolean diretorioRenamed = diretorio.renameTo(diretorioRenomeado);
//        System.out.println("Diretório renomeado?" + diretorioRenamed);
        buscarArquivos();


    }
    public static void buscarArquivos(){
        File file = new File("C:\\Users\\Windows\\IdeaProjects\\logica");
        String[] list = file.list();
        for(String arquivo : list){
            System.out.println(arquivo);
        }
    }
}
