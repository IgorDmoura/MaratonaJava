package MaratonaJava.ZZGcomportamentoporparametro.predicate;

import MaratonaJava.ZZGcomportamentoporparametro.classes.Carro;
import MaratonaJava.ZZGcomportamentoporparametro.interfaces.CarroPredicate;

import java.util.Calendar;

public class CarrosDezAnosRecentePredicate implements CarroPredicate {
    @Override
    public boolean test(Carro carro) {
        return carro.getAno() >= (Calendar.getInstance().get(Calendar.YEAR)- 10);
    }
}
