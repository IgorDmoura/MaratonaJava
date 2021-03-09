package MaratonaJava.Xnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CriandoPathExercicio {
    public static void main(String[] args) {
        Path p1 = Paths.get("C:\\Users\\Windows\\IdeaProjects\\logica\\teste\\subpasta\\arquivo.txt");
        Path arquivo = Paths.get("C:\\Users\\Windows\\IdeaProjects\\logica\\teste\\subpasta", "arquivo.txt");
        Path arquivo2 = Paths.get("C:\\Users\\Windows\\IdeaProjects\\logica\\teste\\subpasta", "arquivo2.txt");
        Path Localdacolagem = Paths.get("C:\\Users\\Windows\\IdeaProjects\\logica\\colagem\\subpastacolagem");

        System.out.println(p1.toAbsolutePath());
        try {
            if (Files.notExists(p1.getParent()))
                Files.createDirectories(p1.getParent());
            if (Files.notExists(arquivo))
                Files.createFile(arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path source = Paths.get("C:\\Users\\Windows\\IdeaProjects\\logica\\teste\\subpasta\\arquivo.txt");
        Path target = Paths.get(Localdacolagem.toString()+"\\arquivo.txt");

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
