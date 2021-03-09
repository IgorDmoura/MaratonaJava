package MaratonaJava.Xnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributesTest {
    public static void main(String[] args) {
        Path path = Paths.get("folder3\\teste.txt");
        try {
//            Files.createFile(path);
            Files.setAttribute(path,"dos:hidden",true); //Defini como invisivel
            Files.setAttribute(path,"dos:readonly",true); //Defini como somente leitura
            DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println(dos.isHidden());
            System.out.println(dos.isReadOnly());
            DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);
            dosView.setHidden(false); //Defini como invisivel
            dosView.setReadOnly(false); //Defini como somente leitura
            dos = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println(dos.isHidden());
            System.out.println(dos.isReadOnly());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
