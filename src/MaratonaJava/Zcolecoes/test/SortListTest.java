package MaratonaJava.Zcolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListTest {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Willian");
        nomes.add("Suane");
        nomes.add("DevDojo");
        nomes.add("Brenon");
        nomes.add("Bruno");
        nomes.add(0, "Anna");
        Collections.sort(nomes); //Ordena a lista em ordem alfabética

        List<Double> numeros = new ArrayList<>();
        numeros.add(1.5);
        numeros.add(1.3);
        numeros.add(1.9);
        numeros.add(2d);
        Collections.sort(numeros); //Ordena numeros por ordem de tamanho

        for (String nome : nomes) {
            System.out.println(nome);
        }

        for (Double numero : numeros) {
            System.out.println(numero);
        }
    }
}
