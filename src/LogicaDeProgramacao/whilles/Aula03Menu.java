package LogicaDeProgramacao.whilles;

import java.util.Scanner;

public class Aula03Menu {
    public static void main(String[] args) {

        int opcao= 0;
        Scanner teclado = new Scanner(System.in);
        while(opcao != 3) {
            System.out.println("1-Calcular Imposto");
            System.out.println("2-Depositar Salário");
            System.out.println("3-Sair");
            opcao = teclado.nextInt();
        }
        System.out.println("Programa Encerrado");
    }
}
