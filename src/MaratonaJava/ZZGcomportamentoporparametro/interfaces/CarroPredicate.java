package MaratonaJava.ZZGcomportamentoporparametro.interfaces;

import MaratonaJava.ZZGcomportamentoporparametro.classes.Carro;
@FunctionalInterface
public interface CarroPredicate {
    boolean test(Carro carro);
}
