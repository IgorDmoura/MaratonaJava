package LogicaDeProgramacao.OperadorTernario;

public class OperadorTernario {
    public static void main(String[] args) {

        int idade = 15;
        String status;

        status = idade < 18 ? "Não-Adulto" : "Adulto";
        System.out.println(status);

    }
}
