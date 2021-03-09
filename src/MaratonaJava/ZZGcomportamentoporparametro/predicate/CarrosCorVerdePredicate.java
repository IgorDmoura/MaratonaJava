package MaratonaJava.ZZGcomportamentoporparametro.predicate;

import MaratonaJava.ZZGcomportamentoporparametro.classes.Carro;
import MaratonaJava.ZZGcomportamentoporparametro.interfaces.CarroPredicate;

public class CarrosCorVerdePredicate implements CarroPredicate {

    @Override
    public boolean test(Carro carro) {
        return carro.getCor().equals("verde");
    }
}
