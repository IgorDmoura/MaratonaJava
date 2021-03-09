package MaratonaJava.Xnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizarTest {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/willian");
        Path classe = Paths.get("/home/willian/java/Pessoa.java");
        Path classepath = dir.relativize(classe); //Mostra pro dir como chegar no pessoa.java usando informacao do classe
        System.out.println(classepath); //Relativase - Elimina Resolverndo - Junta

        Path absolute1 = Paths.get("/home/willian");
        Path absolute2 = Paths.get("/usr/local");
        Path absolute3 = Paths.get("/home/willian/java/Pessoa.java");
        Path relative1 = Paths.get("temp");
        Path relative2 = Paths.get("temp/Funcionario.java");
        System.out.println("1: " + absolute1.relativize(absolute3));
        System.out.println("2: " + absolute3.relativize(absolute1));
        System.out.println("3: " + absolute1.relativize(absolute2));
        System.out.println("4: " + relative1.relativize(relative2));
        System.out.println("5: " + absolute1.relativize(relative1));
                         //Estou no Path 1, e quero chegar no Path 2
        
    }
}
