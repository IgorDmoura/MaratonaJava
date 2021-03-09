package MaratonaJava.Lclassesabstratas.classes.Exercicio.test;

import MaratonaJava.Lclassesabstratas.classes.Exercicio.classes.Homem;
import MaratonaJava.Lclassesabstratas.classes.Exercicio.classes.Mulher;

public class SerHumanoTest {
    public static void main(String[] args) {
        Homem h = new Homem("João", 20);
        Mulher m = new Mulher("Ana",17);
        System.out.println(h);
        System.out.println(m);
        h.imprime();
        m.imprime();
    }
}
