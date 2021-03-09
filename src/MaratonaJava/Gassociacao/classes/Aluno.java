package MaratonaJava.Gassociacao.classes;

public class Aluno {
    private Seminário seminario;
    private String nome;
    private int idade;

    public Aluno() {
    }

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void print(){
        System.out.println("---------------Relatório de Alunos---------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        if(seminario != null) {
            System.out.println("Seminário inscrito: " + this.seminario.getTitulo());
            return;
        }
            System.out.println("O aluno não está inscrito em nenhum seminário");
    }

    public Seminário getSeminario() {
        return seminario;
    }

    public void setSeminario(Seminário seminario) {
        this.seminario = seminario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
