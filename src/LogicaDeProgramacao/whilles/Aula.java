package LogicaDeProgramacao.whilles;

import java.util.Scanner;

public class Aula {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Seja Bem-vindo ao Menu");
        System.out.println("Digite o número da opção desejada");
        System.out.println("---------------------------------");

        int opcao = 0;

        while (opcao != 3) {
            System.out.println("1-Calcular Imposto");
            System.out.println("2-Depositar Salário");
            System.out.println("3-Sair");
            opcao = teclado.nextInt();

        }


    }

}

