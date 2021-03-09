package MaratonaJava.Lclassesabstratas.test;

import MaratonaJava.Lclassesabstratas.classes.Gerente;
import MaratonaJava.Lclassesabstratas.classes.Vendedor;

public class FuncionarioTest {
    public static void main(String[] args) {
        Gerente g = new Gerente("Anna","21512-5",2000);
        Vendedor v = new Vendedor("Igor","20987-5",2000,5000);
        g.calculaSalario();
        v.calculaSalario();
        System.out.println(g);
        System.out.println("--------------------");
        System.out.println(v);
    }
}
