package MaratonaJava.Npolimorfismo.Zexercicio.classes;

public class Movimentavel {
    public void movimentar(Animal animal){
        if(animal instanceof Peixe){
            System.out.println(((Peixe) animal).getNome() + " está nadando");
        }
        if(animal instanceof Cobra){
            System.out.println(((Cobra) animal).getNome() + " está rastejando");
        }
    }
}
