package MaratonaJava.Xnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AtributosBasicosTest {
    public static void main(String[] args) throws IOException {
       //Forma Antiga
        Date primeiroDeDezembro = new GregorianCalendar(2015, Calendar.DECEMBER,1).getTime();
        File file = new File("folder3\\arquivo2.txt");
        file.createNewFile();
        file.setLastModified(primeiroDeDezembro.getTime());//Passar tempo do date em forma de long
        System.out.println(file.lastModified());
        file.delete();

        //Forma Nova
        Path path = Paths.get("folder3\\arquivo_path.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.fromMillis(primeiroDeDezembro.getTime());
        Files.setLastModifiedTime(path,fileTime);
        System.out.println(Files.getLastModifiedTime(path));
        Files.deleteIfExists(path);

        //Atributos Básicos
        path = Paths.get("src\\javacore\\Aintroduçãoclasses\\classes\\Carro.java");
        System.out.println(Files.isReadable(path)); //Verifica se é possivel fazer a leitura
        System.out.println(Files.isWritable(path)); //Verifica se é possivel fazer a escrita
        System.out.println(Files.isExecutable(path)); //Verifica se é possivel fazer a execução

        //Servem para leitura: (Interfaces)
        //BasicFileAttributes - Atributos Básicos para todos S.O
        //PosixFileAttributes - Atributos Baseados no Unix e Linux
        //DosFileAttributes - Atributos Baseados no Windows

        BasicFileAttributes atributosbasicos = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("create: " + atributosbasicos.creationTime());
        System.out.println("lastacess: " + atributosbasicos.lastAccessTime());
        System.out.println("lastmodified: " + atributosbasicos.lastModifiedTime());
        System.out.println("-----------------------");
//        System.out.println(atributosbasicos.isDirectory());
//        System.out.println(atributosbasicos.isSymbolicLink());
//        System.out.println(atributosbasicos.isRegularFile());

        //Servem para alterar: (Inferfaces)
        //BasicFileAttributeView
        //PosixFileAttributeView
        //DosFileAttribute
        //FileOwnerAttributeView - Usado para setar o dono do arquivo
        //AclFileAttributeView - Permissoes mais avançadas para trabalhar diretorios e arquivos

        //Sempre que for ler será readAttribute, se for pra editar terá VIEW no nome

        FileTime lastModified = atributosbasicos.lastModifiedTime();
        FileTime created = atributosbasicos.creationTime();
        FileTime lastAcess = FileTime.fromMillis(System.currentTimeMillis());

        BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        basicView.setTimes(lastModified,lastAcess,created);
        atributosbasicos = Files.readAttributes(path, BasicFileAttributes.class);

        System.out.println("create: " + atributosbasicos.creationTime());
        System.out.println("lastacess: " + atributosbasicos.lastAccessTime());
        System.out.println("lastmodified: " + atributosbasicos.lastModifiedTime());




    }
}
