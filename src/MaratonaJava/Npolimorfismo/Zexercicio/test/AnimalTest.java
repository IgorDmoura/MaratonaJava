package MaratonaJava.Npolimorfismo.Zexercicio.test;

import MaratonaJava.Npolimorfismo.Zexercicio.classes.Animal;
import MaratonaJava.Npolimorfismo.Zexercicio.classes.Cobra;
import MaratonaJava.Npolimorfismo.Zexercicio.classes.Movimentavel;
import MaratonaJava.Npolimorfismo.Zexercicio.classes.Peixe;

public class AnimalTest {
    public static void main(String[] args) {
        Animal a = new Cobra("Cascavel",5,true);
        Animal a1 = new Peixe("Nemo",10);
        Movimentavel movimentar = new Movimentavel();
        movimentar.movimentar(a1);
        System.out.println("--------------------");
        movimentar.movimentar(a);
    }
}
