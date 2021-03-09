package MaratonaJava.Xnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FindAllTest extends SimpleFileVisitor<Path>{
    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Test*}.{java,class}");
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(matcher.matches(file)){
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}

public class PatchMatcherTest {
    public static void main(String[] args) throws IOException {
        // glob - qualquer palavra // ** ou /* qualquer coisa // * qualquer coisa que nao tenha separador de diretorio
        // ??? busca 3 letras, ?? busca duas e assim vai
        Path path1 = Paths.get("pasta/subpasta/subsubpasta/file.bkp");
        Path path2 = Paths.get("file.bkp");
        Path path3 = Paths.get("Willian-suane");
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.bkp");
        System.out.println(matcher.matches(path1));
        System.out.println(matcher.matches(path2));
        System.out.println("-------------------------");
        matches(path1,"glob:.bkp");
        matches(path1,"glob:**.bkp");
        matches(path1,"glob:*");
        matches(path1,"glob:**");
        System.out.println("-----------------------");
        matches(path1,"glob:*.???");
        matches(path1,"glob:**/*.???");
        matches(path1,"glob:**.???");
        System.out.println("-----------------------");
        matches(path3,"glob:{Willian*,suane*}"); //Os dois um ou dos dois
        matches(path3,"glob:{Willian,suane}*"); //Os dois um ou dos dois
        matches(path3,"glob:{Willian,suane}"); //Exatamente Willian ou suane
        Files.walkFileTree(Paths.get("./"), new FindAllTest());
    }

    private static void matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}
