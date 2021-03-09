package MaratonaJava.ZZNdatetime.util;


import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class ObterProximoDiaUtil implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int proximodia = 1;
        switch (dayOfWeek){
            case FRIDAY: proximodia = 3;break;
            case SATURDAY:proximodia = 2;break;
        }
        return temporal.plus(proximodia, ChronoUnit.DAYS);
    }
}

//Esse codigo para mostrar o proximo dia util
//Ele adiciona ao temporal (tempo atual) os dias necessarios
//para mostra o proximo dia util

