package MaratonaJava.Xnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest { //Sempre que for Stream tem que fechar
    public static void main(String[] args) {
        Path dir = Paths.get("pasta");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for(Path path : stream){
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

