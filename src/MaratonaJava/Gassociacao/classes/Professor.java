package MaratonaJava.Gassociacao.classes;

public class Professor {
    private Seminário[] seminarios;
    private String nome;
    private String especialidade;

    public Professor() {
    }

    public Professor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public void print() {
        System.out.println("---------------Relatório de Professor---------------");
        System.out.println("Nome do professor: " + this.nome);
        System.out.println("Especialidade: " + this.especialidade);
        if (seminarios != null && seminarios.length != 0) {
            System.out.println("----Seminários participantes----");
            for (Seminário sem : seminarios) {
                System.out.println(sem.getTitulo());
            }
            return;
        }
        System.out.println("Professor não inscrito em nenhum seminário");
    }

    public Seminário[] getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(Seminário[] seminarios) {
        this.seminarios = seminarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
