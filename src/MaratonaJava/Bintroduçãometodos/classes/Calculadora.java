package MaratonaJava.Bintroduçãometodos.classes;

public class Calculadora {

    public static void somaDoisNumeros() {
        System.out.println(5 + 5);
    }

    public static void subtraiDoisNumeros() {
        System.out.println(5 - 5);
    }

    public static void multiplicaDoisNumeros(double num1, int num2) {
        System.out.println(num1 * num2);
    }

    public static double dividiDoisNumeros(double num1, double num2) {

        if (num2 != 0) {
            return num1 / num2;
        }
        return 0;
    }

    public static void imprimirDoisNumerosDivididos(double num1, double num2) {
        if (num2 != 0) {
            System.out.println(num1 / num2);
            return;
        }
            System.out.println("Não é possível dividir por 0");
        }

        public static void alteraDoisNumeros(int num1, int num2) {
        num1 = 30;
        num2 = 40;
            System.out.println("Dentro do altera dois numeros");
            System.out.println("Num1: " + num1);
            System.out.println("Num2: " + num2);
        }

        public static void somaArray(int[] numeros) {
        int soma = 0;
        for(int num : numeros){ //Puxa o Endereço do array numero
            soma += num; // Soma recebe numeros de num que puxou endereço do array
        }
            System.out.println(soma);
        }

//Pode adicionar parametros no var args, desde que var args seja o ultimo

        public static void somaVarArgs(double teste , int... numeros) { //Somente 1 var args por metodo
            int soma = 0;
            for(int num : numeros){ //Puxa o Endereço do array numero
                soma += num; // Soma recebe numeros de num que puxou endereço do array
            }
            System.out.println(soma);
        }
    }

