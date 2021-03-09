package MaratonaJava.ZZAGenerics.test;

import MaratonaJava.ZZAGenerics.classes.Computador;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaExercicioAula134 {
    public static void main(String[] args) {
        List<Computador> computadores = new ArrayList<>();
        computadores.add(new Computador("Samsung"));
        computadores.add(new Computador("Sony"));
        DispositivosVenda<Computador> computadorCompravel = new DispositivosVenda<>(computadores);
        computadorCompravel.exibirProdutos();
        computadorCompravel.comprarProdutos();

    }

    static class DispositivosVenda<T> {
        private List<T> DispositivosVenda = new ArrayList<>();

        public DispositivosVenda(List<T> Dispostivosnaloja) {
            this.DispositivosVenda = Dispostivosnaloja;
        }


        public void exibirProdutos() {
            System.out.println(DispositivosVenda.toString());
        }

        public void comprarProdutos() {
            T t = DispositivosVenda.remove(0);
            System.out.println("Dispositivo comprado: " + t);
            System.out.println("Dispositivos Disponiveis: " + DispositivosVenda);
        }
    }
}




