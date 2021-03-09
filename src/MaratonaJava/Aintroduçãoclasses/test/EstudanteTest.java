package MaratonaJava.Aintroduçãoclasses.test;

import MaratonaJava.Aintroduçãoclasses.classes.Estudante;

public class EstudanteTest {
    public static void main(String[] args) {
        Estudante joao = new Estudante();
        joao.nome = "João";
        joao.matrícula = "1212";
        joao.idade = 15;

        System.out.println(joao.nome);
        System.out.println(joao.matrícula);
        System.out.println(joao.idade);
    }
}
