package MaratonaJava.Zcolecoes.test;

import MaratonaJava.Zcolecoes.classes.Consumidor;
import MaratonaJava.Zcolecoes.classes.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumidorMapTest {
    public static void main(String[] args) {
        Consumidor consumidor = new Consumidor("Willian Suane","122");
        Consumidor consumidor2 = new Consumidor("DevDojo","321");
        //Nao pode criar consumidor repetido (Key)
        Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.0);
        Produto produto2 = new Produto("321", "Picanha", 26.4);
        Produto produto3 = new Produto("879", "Teclado Razer", 1000.0);
        Produto produto4 = new Produto("123", "Samsung Galxy S7 64GB", 3250.5);

        Map<Consumidor, List<Produto>> map = new HashMap<>(); //Consumidor e Lista do que comprou

        List<Produto> produtoCon1 = new ArrayList<>();
        produtoCon1.add(produto1);
        produtoCon1.add(produto2);
        List<Produto> produtoCon2 = new ArrayList<>();
        produtoCon2.add(produto3);
        produtoCon2.add(produto4);

        //Métodos
        //map.put - Defini a key e valor - ex: Consumidor e produto
        //map.remove - remove um item - informando a key desejada
        //map.containskey ou map.containsvalue - Saber se o valor ou key existe

        map.put(consumidor,produtoCon1);
        map.put(consumidor2,produtoCon2);
        for(Map.Entry<Consumidor,List<Produto>> entry : map.entrySet()){
            System.out.println(entry.getKey().getNome() + ":"); //Mostra o nome do consumidor(Key)
            for(Produto produto : entry.getValue()){
                System.out.println(produto.getNome());//Mostra o nome do produto(Value)
            }
        }







    }
}
