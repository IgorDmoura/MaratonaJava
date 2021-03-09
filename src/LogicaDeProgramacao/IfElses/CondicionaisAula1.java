package LogicaDeProgramacao.IfElses;

import java.util.Scanner;

public class CondicionaisAula1 {

    public static void main(String[] args) {

        String Sexo = "";
        String Feminino = "F";
        String Masculino = "M";
        int Idade = 0;

        System.out.println("Digite seu Sexo: F ou M ");

        Scanner teclado = new Scanner(System.in);
        Sexo = teclado.next();

        System.out.println("Digite sua idade: ");

        teclado = new Scanner(System.in);
        Idade = teclado.nextInt();

        if (Sexo.equalsIgnoreCase(Masculino) && Idade >= 18) {

            System.out.println("Alistamento Obrigatório");
        } else if (Sexo.equalsIgnoreCase(Masculino) && Idade < 18) {

            System.out.println("Alistamento não permitido");
        } else if (Sexo.equalsIgnoreCase(Feminino) && Idade >= 18) {

            System.out.println("Alistamento é Opcional");
        } else if (Sexo.equalsIgnoreCase(Feminino) && Idade < 18) {

            System.out.println("Alistamento não permitido");
        } else {

            System.out.println("Não foi possível identificar o gênero");
        }
    }
}
