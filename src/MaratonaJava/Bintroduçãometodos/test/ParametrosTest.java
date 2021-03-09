package MaratonaJava.Bintroduçãometodos.test;

import MaratonaJava.Bintroduçãometodos.classes.Calculadora;

public class ParametrosTest {
    public static void main(String[] args) {

        int num1 = 5;
        int num2 = 10;
        Calculadora calc = new Calculadora();
        calc.alteraDoisNumeros(num1,num2);
        System.out.println("Dentro do Teste");
        System.out.println("Num1: " + num1);
        System.out.println("Num2: " + num2);

        //Mesmo que o calc.alteraDoisNumeros tenha argumento com valores diferente
        // O valor original do Int nao será alterado
        // Será apenas feito uma copia com outro valor, mas o valor de int num1
        // e num 2 será o mesmo, nesse caso acima
        // o num1 continua 5 e num 2 continua 10, mesmo recebendo valores do calc
    }
}
