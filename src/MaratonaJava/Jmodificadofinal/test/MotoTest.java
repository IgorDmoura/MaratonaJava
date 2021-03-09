package MaratonaJava.Jmodificadofinal.test;

import MaratonaJava.Jmodificadofinal.classes.Moto;

public class MotoTest {
    public static void main(String[] args) {
        Moto moto = new Moto();
        moto.getCompradorMoto().setNome("Igor");
        System.out.println(moto);
    }
}