package MaratonaJava.ZZHlambdas.interfaces;


import MaratonaJava.ZZHlambdas.classes.Carro;

@FunctionalInterface
public interface CarroPredicate {
    boolean test(Carro carro);
    //(parametro) -> <expressao>
    //(Carro carro) -> carro.getCor().equals("verde");
}
