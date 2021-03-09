package MaratonaJava.Npolimorfismo.Zexercicio.classes;

public class Cobra extends Animal{
    private String nome;
    private int idade;
    private boolean venenosa;

    public Cobra(String nome, int idade, boolean venenosa) {
        this.nome = nome;
        this.idade = idade;
        this.venenosa = venenosa;
    }

    @Override
    public String toString() {
        return "Cobra{" +
                "nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                ", venenosa=" + venenosa +
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

    public boolean isVenenosa() {
        return venenosa;
    }

    public void setVenenosa(boolean venenosa) {
        this.venenosa = venenosa;
    }
}
