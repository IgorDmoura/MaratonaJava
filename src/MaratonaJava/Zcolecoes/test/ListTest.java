package MaratonaJava.Zcolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {

        System.out.println("Usando ForEach");
        List<String> nomes = new ArrayList<>(); //Cria ArrayList de String
        nomes.add("Willian");
        nomes.add("DevDojo");
        nomes.add("Suane");
        //Remover de duas Formas (Usando a String ou a posicao indice)
        nomes.remove(1);
        //Tamanho do array
        System.out.println("Size: " + nomes.size());
        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println("------------------");

        System.out.println("Usando For");
        List<String> nomes2 = new ArrayList<>(); //Cria ArrayList de String
        nomes2.add("Willian2");
        nomes2.add("DevDojo2");
        nomes2.add("Suane2");
        nomes2.addAll(nomes); //Adiciona todos os elementos de um array em outro array
        //Remover de duas Formas (Usando a String ou a posicao indice)
        nomes2.remove("DevDojo2");
//        nomes2.clear(); //Apaga todos os elementos que foi adicionado mas o array ainda existe
        int size = nomes2.size();
        for (int i = 0; i < size; i++) {
            System.out.println(nomes2.get(i));
        }


        System.out.println("--------------------------");

        System.out.println("ArrayList Integer");
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        for (Integer num : numeros) {
            System.out.println(num);
        }
    }
}
