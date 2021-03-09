package MaratonaJava.Minterfaces.classes;

public class Carro implements Tributavel{
// private > default > protected > public -- ++ restrito para o menos restrito
    @Override
    public void calculaImposto() { //Override em subclasse nao pode ser mais restrito que na super classe.
// Sempre que for sobreescrita de interface, o método tem que ser publico

    }
}
