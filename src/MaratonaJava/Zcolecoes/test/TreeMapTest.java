package MaratonaJava.Zcolecoes.test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        NavigableMap<String,String> map = new TreeMap<>();
//        Consumidor consumidor = new Consumidor("Willian Suane","122");
//        Consumidor consumidor2 = new Consumidor("DevDojo","321");
        map.put("A", "Letra A");
        map.put("D", "Letra D");
        map.put("B","Letra B");
        map.put("C","Letra C");

        //Ele organiza sempre com base na Key, no caso de ser String foi em ordem Alfabética
        //A Classe que vai na Key tem que ter o método comparator, se nao da ClassCastException

        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " +entry.getValue());
        }

        //Método Uteis
        //map.headmap = Retorna um map com as chaves menores do que a chave passada
        System.out.println(map.headMap("C",true)); //Se por true ele mostra a chave tambem
        //map.pollFirtEntry e map.pollLastEntry - Retorna e remove o primeiro e ultimo key e valor respectivamente
        //lower entry ou key - Retorna o ultimo/anterior mas sem contar se é igual ou não
        //floor entry ou key - Menor ou igual
        //Higher entry ou key - Maior
        //Celling entry ou key - Maior ou igual
        System.out.println(map.higherEntry("C"));
        //descendingKeySet - Deixa em ordem inversa as keys
        //descendingMap - Deixa em ordem inversa os valores
        System.out.println(map.descendingKeySet());
        System.out.println(map.descendingMap());



    }
}
