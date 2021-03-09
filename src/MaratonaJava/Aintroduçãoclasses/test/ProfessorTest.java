package MaratonaJava.Aintroduçãoclasses.test;

import MaratonaJava.Aintroduçãoclasses.classes.Professor;

public class ProfessorTest {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.nome ="Pedro";
        professor.matricula ="0001";
        professor.rg ="134280118";
        professor.cpf ="38494463950";
        Professor professor2 = new Professor();
        professor2.nome ="João";
        professor2.matricula ="0002";
        professor2.rg ="184289518";
        professor2.cpf ="68457463859";


        System.out.println("Nome: " + professor.nome);
        System.out.println("Matrícula: " + professor.matricula);
        System.out.println("RG: " + professor.rg);
        System.out.println("CPF: " + professor.cpf);
        System.out.println("____________________________________");
        System.out.println("Nome: " + professor2.nome);
        System.out.println("Matrícula: " + professor2.matricula);
        System.out.println("RG: " + professor2.rg);
        System.out.println("CPF: " + professor2.cpf);
    }
}
