package MaratonaJava.ZZFpadroesdeprojeto.test;

import MaratonaJava.ZZFpadroesdeprojeto.classes.AviaoSingletonEnum;

public class AviaoSingletonEnumTest {
    public static void main(String[] args) {
        AviaoSingletonEnum.agendarAssento("1A");
        AviaoSingletonEnum.agendarAssento("1A");
    }
}
