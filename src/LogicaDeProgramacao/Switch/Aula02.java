package LogicaDeProgramacao.Switch;

import java.util.Scanner;

public class Aula02 {

    public static void main(String[] args) {

        int TipodeConta = 0;
        String ContaCorrente = "";
        String ContaPoupanca = "";
        String ContaInvestimento = "";

        System.out.println("Digite o número correspondente a sua conta: (1-Corrente, 2-Poupança ou 3-Investimento)");

        Scanner teclado = new Scanner(System.in);
        TipodeConta = teclado.nextInt();

        switch (TipodeConta) {
            case 1:
                System.out.println("A conta Corrente tem uma taxa de Juros de 0,02%");
                break;
            case 2:
                System.out.println("A conta Poupança tem uma taxa de Juros de 0,05%");
                break;
            case 3:
                System.out.println("A conta Investimento tem uma taxa de Juros de 0,01%");
                break;
            default:
                System.out.println("Tipo de conta Inválida");
        }
    }
}
