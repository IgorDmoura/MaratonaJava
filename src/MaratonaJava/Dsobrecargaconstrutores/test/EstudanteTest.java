package MaratonaJava.Dsobrecargaconstrutores.test;

import MaratonaJava.Dsobrecargaconstrutores.classes.Estudante;

public class EstudanteTest {
    public static void main(String[] args) {
        Estudante est = new Estudante("1234-5","João", new double []{5,7,9});
        est.imprime();
    }
}
