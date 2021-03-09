package MaratonaJava.Bintroduçãometodos.test;

import MaratonaJava.Bintroduçãometodos.classes.Calculadora;

public class CalculadoraTest {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Calculadora.somaDoisNumeros();
        Calculadora.subtraiDoisNumeros();
        Calculadora.multiplicaDoisNumeros(55.5,5);
        double result = Calculadora.dividiDoisNumeros(20,0);
        System.out.println(result);
        System.out.println("Imprimi Dois Numeros Divididos");
        Calculadora.imprimirDoisNumerosDivididos(20,0);
        System.out.println("Continuando a execução");

        int[] numeros = {1,2,3,4,5};
        Calculadora.somaArray(numeros);
        Calculadora.somaVarArgs(1,2,3,4,5,6,7,8); // Todos numeros Adicionados
        //Serão parte do Array criado automaticamente
    }

}
