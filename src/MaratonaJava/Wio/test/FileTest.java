package MaratonaJava.Wio.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt"); //Cria arquivo
        try {
            boolean exists = file.exists();   // Se criar arquivo da true, se ja exister ou tiver outro mesmo nome da false
            System.out.println("Criar Arquivo? " + file.createNewFile()); //Cria arquivo
            System.out.println("Permissão de leitura? " + file.canRead()); //Verifica permissao de leitura
            System.out.println("path " + file.getPath()); //Mostra o path(Diretorio)
            System.out.println("path " + file.getAbsolutePath()); //Mostra path (Diretorio Completp)
            System.out.println("diretorio " + file.isDirectory()); //Verifica se é um diretório ou arquivo
            System.out.println("Arquivo oculto? " + file.isHidden()); //Verifica se é um arquivo oculto
            System.out.println("Ultima modificacao: " + new Date(file.lastModified()));
            if(exists){
                System.out.println("Existe? " + file.exists());
                file.delete();
                System.out.println("O arquivo foi deletado");
            }else{
                System.out.println("Existe? " + file.exists());
                System.out.println("Criar Arquivo? " + file.createNewFile());
                System.out.println("O arquivo foi criado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
