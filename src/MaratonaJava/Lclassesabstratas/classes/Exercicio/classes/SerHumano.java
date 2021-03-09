package MaratonaJava.Lclassesabstratas.classes.Exercicio.classes;

public abstract class SerHumano {
    protected String nome;
    protected int idade;
    protected final String planeta = "Terra";

    public SerHumano() {
    }

    public SerHumano(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "SerHumano{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", planeta='" + planeta + '\'' +
                '}';
    }

    public abstract void imprime();

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

    public String getPlaneta() {
        return planeta;
    }
}
