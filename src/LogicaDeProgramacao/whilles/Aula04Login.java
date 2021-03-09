package LogicaDeProgramacao.whilles;

import java.util.Scanner;

public class Aula04Login {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        while (true) {
            String Login = "Igor";
            String password = "Batata";
            System.out.println("Digite seu Login:");
            Login = teclado.next();
            System.out.println("Digite sua Senha:");
            password = teclado.next();

            if (Login.equals("Igor") && password.equals("Batata")) {
                System.out.println("Acesso Concedido");
                break;
            } else {
                System.out.println("Acesso Negado");
            }


        }
    }
}
