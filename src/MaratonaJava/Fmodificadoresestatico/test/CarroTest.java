package MaratonaJava.Fmodificadoresestatico.test;

import MaratonaJava.Fmodificadoresestatico.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro c1 = new Carro("BMW", 280);
        Carro c2 = new Carro("Audi", 275);
        Carro c3 = new Carro("Mercedes", 290);

        c1.imprime();
        c2.imprime();
        c3.imprime();

        System.out.println("_________________");//Nao pode acessar atributos nao estaticos em metodos estaticos

        Carro.setVelocidadeLimite(220);// Por ser estatico, mudou valor da classe, e alterou todos objetos

        c1.imprime();
        c2.imprime();
        c3.imprime();
    }
}
