package MaratonaJava.ZZFpadroesdeprojeto.test;

import MaratonaJava.ZZFpadroesdeprojeto.classes.Moeda;
import MaratonaJava.ZZFpadroesdeprojeto.classes.MoedaFactory;
import MaratonaJava.ZZFpadroesdeprojeto.classes.Pais;

public class MoedaFactoryTest {
    public static void main(String[] args) {
        Moeda moeda = MoedaFactory.criarMoeda(Pais.EUA);
        System.out.println(moeda.getSimbolo());
    }
}
