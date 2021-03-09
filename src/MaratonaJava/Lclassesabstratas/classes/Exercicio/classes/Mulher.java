package MaratonaJava.Lclassesabstratas.classes.Exercicio.classes;

public class Mulher extends SerHumano {
    public Mulher() {
    }

    public Mulher(String nome, int idade) {
        super(nome, idade);
    }

    public void imprime() {
        System.out.println("Imprime Mulher");
    }

}
