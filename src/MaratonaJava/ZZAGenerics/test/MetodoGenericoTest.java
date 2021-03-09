package MaratonaJava.ZZAGenerics.test;

import java.util.ArrayList;
import java.util.List;

public class MetodoGenericoTest {
    public static void main(String[] args) {
        criarArray(new Cachorro());

    }

    public static <T extends Animal> void criarArray(T t) {
        List<T> lista = new ArrayList<>();
        lista.add(t);
        System.out.println(lista);
    }
}
//T extends Animal - obriga a classe que ira ser definida a ser subclasse de Animal