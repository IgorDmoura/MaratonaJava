package MaratonaJava.ZZAGenerics.test;

import MaratonaJava.ZZAGenerics.classes.Carro;
import MaratonaJava.ZZAGenerics.classes.Computador;

import java.util.ArrayList;
import java.util.List;

public class ClasseNaoGenericaTest {
    public static void main(String[] args) {
        CarroAlugavel carroAlugavel = new CarroAlugavel();
        Carro carroAlugado = carroAlugavel.getCarroDisponivel();
        System.out.println("Usando carro por um mês");
        carroAlugavel.devolverCarro(carroAlugado);

        System.out.println("---------------------");
        ComputadorAlugavel computadorAlugavel = new ComputadorAlugavel();
        Computador computador = computadorAlugavel.getComputadorDisponivel();
        System.out.println("Computador usado por um mês");
        computadorAlugavel.devolverComputador(computador);


    }
}

class CarroAlugavel {
    private List<Carro> carrosDisponiveis = new ArrayList<>();
    {
        carrosDisponiveis.add(new Carro("Gol"));
        carrosDisponiveis.add(new Carro("BMW"));
    }
    //Alugar
    public Carro getCarroDisponivel() {
        Carro c = carrosDisponiveis.remove(0);
        System.out.println("Alugando carro: " + c);
        System.out.println("Carros disponiveis: " + carrosDisponiveis);

        return c;
    }
    public void devolverCarro(Carro c) {
        System.out.println("Devolvendo carro: " + c);
        carrosDisponiveis.add(c);
        System.out.println("Carros disponiveis: " + carrosDisponiveis);
    }
}

class ComputadorAlugavel {
    private List<Computador> ComputadoresDisponiveis = new ArrayList<>();
    {
        ComputadoresDisponiveis.add(new Computador("Alienware"));
        ComputadoresDisponiveis.add(new Computador("HP"));
    }
    //Alugar
    public Computador getComputadorDisponivel() {
        Computador c = ComputadoresDisponiveis.remove(0);
        System.out.println("Alugando computador: " + c);
        System.out.println("Computadores disponiveis: " + ComputadoresDisponiveis);
        return c;
    }
    public void devolverComputador(Computador c) {
        System.out.println("Devolvendo PC: " + c);
        ComputadoresDisponiveis.add(c);
        System.out.println("PC disponiveis: " + ComputadoresDisponiveis);
    }
}
