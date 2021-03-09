package MaratonaJava.Passertions.test;

public class AssertTest {
    public static void main(String[] args) {
        calculaSalario(100);
        diaDaSemana(9);

    }

    private static void calculaSalario(double salario) {
        assert salario > 0 : "O salário não deve ser menor que 0, o salário veio: " + salario;
        //calculo do salário
    }

    public static void diaDaSemana(int dia) {
        switch (dia) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                assert false;
        }

    }
}





