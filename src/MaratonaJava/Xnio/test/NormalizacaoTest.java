package MaratonaJava.Xnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizacaoTest {
    public static void main(String[] args) {
        String diretorioProjeto = "logica\\arquivo\\willian\\dev";
        String arquivoTxt = "..\\..\\arquivo.txt"; // ..\ volta um diretorio
        Path p1 = Paths.get(diretorioProjeto, arquivoTxt);
        System.out.println(p1);
        System.out.println(p1.normalize());
        Path p2 = Paths.get("a/./b/./c"); // .\ mesmo diretorio
        System.out.println(p2);
        System.out.println(p2.normalize());
 }
}
