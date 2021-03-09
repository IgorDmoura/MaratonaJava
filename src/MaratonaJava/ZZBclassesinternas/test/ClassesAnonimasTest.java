package MaratonaJava.ZZBclassesinternas.test;


import MaratonaJava.ZZAGenerics.classes.Carro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Animal {
    public void andar() {
        System.out.println("Andando");
    }
}

public class ClassesAnonimasTest {
    public static void main(String[] args) {
        Animal a = new Animal() {
            public void andar() {
                System.out.println("Andando Anonimamente");
            }
        };
        a.andar();

        List<Carro> carroList = new ArrayList<>();
        carroList.add(new Carro("BMW"));
        carroList.add(new Carro("Audi"));
        Collections.sort(carroList, new Comparator<Carro>() {

            @Override
            public int compare(Carro o1, Carro o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        }); //Lista + Comparação
        System.out.println(carroList);
    }
}
//Criar Classe Abstrata:
//Ao inves de colocar ; no final da criação do objeto
//Foi colocado uma Classe anonima colocando {} e dentro dessa classe pode sobrescrever os métodos
//Essa sobreescrita servira apenas para o objeto em questão