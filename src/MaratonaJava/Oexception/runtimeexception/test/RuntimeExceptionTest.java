package MaratonaJava.Oexception.runtimeexception.test;

public class RuntimeExceptionTest {
    public static void main(String[] args) {
        try {
            divisao(10, 0);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        System.out.println("teste");
        }
    }

    private static void divisao(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Passe um valor diferente de 0 para num2");
        }
        int result = num1 / num2; // Se o IF for executado as linhas abaixo dele serao executadas
        System.out.println(result); //Caso contrario exibe a mensagem no console
    }

}

