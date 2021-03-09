package MaratonaJava.Jmodificadofinal.classes;

public class CompradorMoto {
    private String nome;

    @Override
    public String toString() {
        return "CompradorMoto{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
