package MaratonaJava.Wio.test;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipandoTest {
    public static void main(String[] args) {
        //1-Onde salvar 2-Onde ta arquivov 3-Zip
        Path dirZip = Paths.get("pasta/subpasta");
        Path dirFiles = Paths.get("pasta/subpasta/subsubpasta");
        Path zipFile = dirZip.resolve("arquivo.zip");
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile.toFile())); //Cria zip
             DirectoryStream<Path> stream = Files.newDirectoryStream(dirFiles)) {
            for(Path path : stream){
                zip.putNextEntry(new ZipEntry((path.getFileName().toString())));
                BufferedInputStream bf = new BufferedInputStream(new FileInputStream(path.toFile()));
                byte[] buff = new byte[2048];
                int bytesread;
                while((bytesread = bf.read(buff)) > 0){
                    zip.write(buff,0,bytesread);
                }
                zip.flush();
                zip.closeEntry();
                bf.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
