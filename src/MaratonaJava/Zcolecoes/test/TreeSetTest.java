package MaratonaJava.Zcolecoes.test;

import MaratonaJava.Zcolecoes.classes.Produto;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0, 0);
        Produto produto2 = new Produto("321", "Picanha", 26.4, 10);
        Produto produto3 = new Produto("879", "Teclado Razer", 1000.0, 5);
        Produto produto4 = new Produto("012", "Samsung Galaxy S7 64GB", 3250.5, 0);
        Produto produto5 = new Produto("999", "Samsung Galaxy S6 64GB", 1d, 0);
        NavigableSet<Produto> produtoNavigableSet = new TreeSet<>();
        //A vantagem do TreeSet - Ao acrescentar elementos, eles ja são ordenados automáticamente
        //No exemplo, como o comparable ta no preço, vai ordenar pelo preço
        produtoNavigableSet.add(produto1);
        produtoNavigableSet.add(produto2);
        produtoNavigableSet.add(produto3);
        produtoNavigableSet.add(produto4);
        produtoNavigableSet.add(produto5);
        for(Produto produto : produtoNavigableSet.descendingSet()){ //DescedingSet Inverter ordem da lista
            System.out.println(produto);
        }
        System.out.println("---------------------");
        //Em relação ao produto passado, obtenha:
        //lower - Retorna o ultimo/anterior mas sem contar se é igual ou não
        //floor - Menor ou igual
        //Higher - Maior
        //Celling - Maior ou igual
        System.out.println(produtoNavigableSet.higher(produto4));
        System.out.println("--------------------");
        System.out.println(produtoNavigableSet.pollFirst()); //Remove o primeiro da lista
        System.out.println(produtoNavigableSet.pollLast()); //Remove o ultimo da lista



    }
}
