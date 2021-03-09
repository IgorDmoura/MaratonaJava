package MaratonaJava.ZZAGenerics.test;

import MaratonaJava.ZZAGenerics.classes.Carro;
import MaratonaJava.ZZAGenerics.classes.Computador;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(); //Cria lista
        carrosDisponiveis.add(new Carro("Gol")); //Coloca na lista
        carrosDisponiveis.add(new Carro("BMW"));
        ObjetosAlugaveis<Carro> carroAlugavel = new ObjetosAlugaveis<>(carrosDisponiveis); //Generica pega a lista
        Carro carro = carroAlugavel.getObjetoDisponivel(); //Aluga o carro (Método)
        System.out.println("Usando carro por um mês");
        carroAlugavel.devolverObjeto(carro); //Devolve o carro (Método)

        System.out.println("---------------------"); //E repete tudo denovo com outro

        List<Computador> ComputadoresDisponiveis = new ArrayList<>();
        ComputadoresDisponiveis.add(new Computador("Alienware"));
        ComputadoresDisponiveis.add(new Computador("HP"));
        ObjetosAlugaveis<Computador> computadorAlugavel = new ObjetosAlugaveis<>(ComputadoresDisponiveis);
        Computador c = computadorAlugavel.getObjetoDisponivel();
        System.out.println("Usando computador");
        computadorAlugavel.devolverObjeto(c);

    }
}

     class ObjetosAlugaveis<T> {
        private List<T> objetosDisponiveis = new ArrayList<>();

        public ObjetosAlugaveis(List<T> objetosDisponiveis) {
            this.objetosDisponiveis = objetosDisponiveis;
        }

        public T getObjetoDisponivel() {
            T t = objetosDisponiveis.remove(0);
            System.out.println("Alugando objeto: " + t);
            System.out.println("Objeto disponiveis: " + objetosDisponiveis);
            return t;
        }

        public void devolverObjeto(T t) {
            System.out.println("Devolvendo objeto: " + t);
            objetosDisponiveis.add(t);
            System.out.println("Objetos disponiveis: " + objetosDisponiveis);
        }
    }

class doisAtributos <T,X>{ //Pode ter mais de um
    T um;
    X dois;

    public doisAtributos(T um, X dois) {
        this.um = um;
        this.dois = dois;
    }

    public T getUm() {
        return um;
    }

    public void setUm(T um) {
        this.um = um;
    }

    public X getDois() {
        return dois;
    }

    public void setDois(X dois) {
        this.dois = dois;
    }
}

