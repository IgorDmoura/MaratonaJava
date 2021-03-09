package LogicaDeProgramacao.IfElses;

import java.util.Scanner;

public class DiaDaSemana<numerodigitado> {

    public static void main(String[] args) {

        int numerodigitado = 1;
        String Segunda = "Segunda-feira";
        String Terça = "Terça-feira";
        String Quarta = "Quarta-feira";
        String Quinta = "Quinta-feira";
        String Sexta = "Sexta-feira";
        String Sábado = "Sábado";
        String Domingo = "Domingo";

        System.out.println("Digite o número: ");

        Scanner teclado = new Scanner(System.in);
        numerodigitado = teclado.nextInt();

        if (numerodigitado == 1) {

            System.out.println(Segunda);
        } else if (numerodigitado == 2) {
            System.out.println(Terça);
        } else if (numerodigitado == 3) {
            System.out.println(Quarta);
        } else if (numerodigitado == 4) {
            System.out.println(Quinta);
        } else if (numerodigitado == 5) {
            System.out.println(Sexta);
        } else if (numerodigitado == 6) {
            System.out.println(Sábado);
        } else if (numerodigitado == 7) {
            System.out.println(Domingo);
        } else if (numerodigitado == 0) {
            System.out.println("O número 0 não corresponde a nenhum dia da semana");
        } else if (numerodigitado > 7) {
            System.out.println("O número " + numerodigitado + " não corresponde a nenhum dia da semana");
        }

    }
}