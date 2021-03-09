package MaratonaJava.Gassociacao.classes;

public class Seminário {
    private Aluno[] alunos;
    private Local local;
    private String titulo;
    private Professor professor;

    public Seminário() {
    }

    public Seminário(String titulo) {
        this.titulo = titulo;
    }

    public void print() {
        System.out.println("---------------Relatório de Seminários---------------");
        System.out.println("Título: " + this.titulo);
        if (this.professor != null)
            System.out.println("Professor palestrante : " + this.professor.getNome());
        else
            System.out.println("Nenhum professor cadastrado para esse seminário");
        if (this.local != null)
            System.out.println("Local: " + this.local.getRua() + " Bairro: " + this.local.getBairro());
        else
            System.out.println("Nenhum local cadastrado para esse seminário");
        if (alunos != null && alunos.length != 0) {
            System.out.println("----Alunos participantes----");
            for (Aluno aluno : alunos) {
                System.out.println(aluno.getNome());
            }
            return;
        }
        System.out.println("Nenhum Aluno cadastrado");
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
