package MaratonaJava.Xnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvendoPaths {
    public static void main(String[] args) {
        //Resolver Path significa Juntar dois Paths
        Path dir = Paths.get("home\\willian");
        Path arquivo = Paths.get("dev\\arquivo.txt");
        Path result  = dir.resolve(arquivo); //Resolve : Junta o dir com arquivo
        System.out.println(result);
        System.out.println("#############");

        Path absolute = Paths.get("home/willian");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("file.txt");

        System.out.println("1- "+absolute.resolve(relativo));
        System.out.println("2- "+absolute.resolve(file));
        System.out.println("3- "+relativo.resolve(file));
        System.out.println("4- "+relativo.resolve(absolute));
        System.out.println("5- "+file.resolve(absolute));
        System.out.println("6- "+file.resolve(relativo));

    }
}
