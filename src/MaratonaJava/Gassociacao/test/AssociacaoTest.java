package MaratonaJava.Gassociacao.test;

import MaratonaJava.Gassociacao.classes.Aluno;
import MaratonaJava.Gassociacao.classes.Local;
import MaratonaJava.Gassociacao.classes.Professor;
import MaratonaJava.Gassociacao.classes.Seminário;

public class AssociacaoTest {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Igor" + "",21);
        Aluno aluno2 = new Aluno("Vanessa" , 16);

        Seminário sem = new Seminário("Como ser um baita programador e ficar rico");
        Professor prof = new Professor("Yoda","Usar a força para programar");
        Local local = new Local("Rua das araras" , "mato");

        aluno.setSeminario(sem);
        aluno2.setSeminario(sem);

        sem.setProfessor(prof);
        sem.setLocal(local);
        sem.setAlunos(new Aluno[]{aluno,aluno2});

        Seminário[]semArray = new Seminário[1];
        semArray[0] = sem;
        prof.setSeminarios(semArray);

        sem.print();
        prof.print();
        local.print();
        aluno.print();
    }
}

