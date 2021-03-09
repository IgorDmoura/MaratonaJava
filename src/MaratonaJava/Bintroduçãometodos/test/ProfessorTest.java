package MaratonaJava.Bintroduçãometodos.test;

import MaratonaJava.Bintroduçãometodos.classes.Professor;

public class ProfessorTest {
    public static void main(String[] args) {

        Professor prof = new Professor();
        prof.cpf = "125.321.654.12";
        prof.matricula = "12254-5";
        prof.nome = "Maria";
        prof.rg = "2154-2";

        Professor prof2 = new Professor();
        prof2.cpf = "126.654.874.12";
        prof2.matricula = "11265-5";
        prof2.nome = "João";
        prof2.rg = "2325-2";

        prof.imprime(); // Imprime as informacao da Classe Professor
        prof2.imprime(); // Imprime as informacao da Classe Professor
        //O This pegou a informaçao dentro da Classe professor
        //E ao puxar o objeto professor, pegou as informacoes puxadas com this


    }
}
