package MaratonaJava.Npolimorfismo.Zexercicio.classes;

public class Peixe extends Animal {
    private String nome;
    private int idade;

    public Peixe(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Peixe{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
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
