package MaratonaJava.Xnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CriandoPathTest {
    public static void main(String[] args) {
        //Formas de chamar Path Endereco
        Path p1 = Paths.get("C:\\Users\\Windows\\IdeaProjects\\logica\\Arquivo.txt");
        Path p2 = Paths.get("C:\\Users\\Windows\\IdeaProjects\\logica", "Arquivo.txt");
        Path p3 = Paths.get("C", "\\Users\\Windows\\IdeaProjects\\logica", "Arquivo.txt");
        Path p4 = Paths.get("C", "Users", "Windows", "IdeaProjects", "logica", "Arquivo.txt");
        System.out.println(p4.toAbsolutePath()); //Mostra o endereco normal
        File file = p4.toFile(); //Tranforma path em file
        Path path = file.toPath();
        Path path1 = Paths.get("pasta");
        Path path2 = Paths.get("pasta\\subpasta\\subpasta\\");
        Path arquivo = Paths.get("pasta\\subpasta\\subpasta\\file.txt");
        try {
//            if(Files.notExists(path1))
//                Files.createDirectory(path1);
            if(Files.notExists(path2.getParent()))
            Files.createDirectories(path2.getParent());
            if(Files.notExists(arquivo))
            Files.createFile(arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path source = Paths.get("folder3\\arquivo.txt"); //Fonte - arquivo a ser copiado
        Path target = Paths.get(path2.toString()+"\\arquivo Copiado.txt");//Alvo - Mudança de nome
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING); //Replace - Copiar e substitui arquivo mesmo ja criado
            Files.deleteIfExists(target); //Deleta se exister
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
