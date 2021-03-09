package LogicaDeProgramacao.Switch;

public class DiasUteis {

    public static void main(String[] args) {

        int dia = 5;

        switch (dia) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Dia útil");
                break;
            case 1:
            case 7:
                System.out.println("Final de Semana");
                break;
            default:
                System.out.println("Dia Inválido");

        }


    }
}
