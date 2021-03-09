package MaratonaJava.Bintroduçãometodos.test;

import MaratonaJava.Bintroduçãometodos.classes.Estudante;

public class EstudanteTest {
    public static void main(String[] args) {

        Estudante estudante = new Estudante();
        estudante.setNome("João");
        estudante.setIdade(-1);
        estudante.setNotas(new double[]{10,10,9,5});

        estudante.informacoesAluno();
        System.out.println("___________________");
        System.out.println(estudante.getNome());
        System.out.println("Aprovado: " +estudante.isAprovado());
    }
}
