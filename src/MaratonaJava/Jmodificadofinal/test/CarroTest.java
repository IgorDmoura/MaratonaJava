package MaratonaJava.Jmodificadofinal.test;

import MaratonaJava.Jmodificadofinal.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro c = new Carro();
        c.getComprador().setNome("Pedro");
        System.out.println(c.getComprador());


    }
}
