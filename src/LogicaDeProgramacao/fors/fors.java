package LogicaDeProgramacao.fors;

import java.util.Scanner;

public class fors {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Digite a nota:");
            notas[i] = teclado.nextDouble();
        }
        int media = 0;
        for (int i = 0; i < notas.length; i++) {
            media = (int) (media + notas[i]);
            System.out.println("Nota: " + (notas[i]));

        }
        System.out.println("Média: " + (media / notas.length));
    }
}


