package MaratonaJava.ZZJoptional.classes;

public class Seguradora {
    private String nome;

    public Seguradora(String nome) {
        this.nome = nome;
    }

    public Seguradora() {
    }

    @Override
    public String toString() {
        return "Seguradora{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public String getNome() { //Retorna o optional ou se tirar so o nome
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
