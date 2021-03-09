package MaratonaJava.Lclassesabstratas.classes.Exercicio.classes;

public class Homem extends SerHumano {
    public Homem() {
    }

    public Homem(String nome, int idade) {
        super(nome, idade);
    }

    public void imprime(){
        System.out.println("Imprime Homem");
    }
}
