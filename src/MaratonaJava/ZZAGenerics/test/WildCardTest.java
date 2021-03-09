package MaratonaJava.ZZAGenerics.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Animal implements Comparable{
    public abstract void consulta();
}
class Cachorro extends Animal{

    @Override
    public void consulta() {
        System.out.println("Consultando cachorro");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Gato extends Animal{

    @Override
    public void consulta() {
        System.out.println("Consultando gato");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

public class WildCardTest {
    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(),new Cachorro()};
        Gato[] gatos = {new Gato(),new Gato()};
//        consultandoAnimais(cachorros);
    //        consultandoAnimais(gatos);

        List<Cachorro> cachorroList = new ArrayList<>();
        cachorroList.add(new Cachorro());
        List<Gato> gatoList = new ArrayList<>();
        gatoList.add(new Gato());

        consultarAnimaisList(cachorroList);
        consultarAnimaisList(gatoList);
        ordernarLista(cachorroList);

    }
    public static void consultandoAnimais(Animal[] animals){
        for(Animal animal : animals){
            animal.consulta();
        }
    }

    //Type erasure - caracter Coringa = ? - Pode adiciona qualquer lista que seja o marcado ou suas subclasse
    public static void consultarAnimaisList(List<? extends Animal> animals){
        Gato gato = new Gato();
        Cachorro cachorro = new Cachorro();
        for(Animal animal : animals){
            animal.consulta();
        }
    }

    public static void consultarCachorrosList(List<? super Cachorro> cachorroList){
            Cachorro c1 = new Cachorro();
            Animal c2 = new Cachorro();
            cachorroList.add(new Cachorro());
    }

    //O ?Extends comparable significa que aceita qualquer classe que tem o comparable ou oque for marcado
    //Na mesma, pode ser uma classe como exemplo Cachorro e gato
    //No caso de classe aceita qualquer classe do mesmo tipo ou super
    public static void ordernarLista(List<? extends Comparable> lista){
        Collections.sort(lista);
    }

}
