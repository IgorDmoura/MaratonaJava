package MaratonaJava.Oexception.runtimeexception.test;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class MultiplasRuntimeExceptionTest {
    public static void main(String[] args) {
        try {
            throw new IndexOutOfBoundsException();

        } catch (IndexOutOfBoundsException | IllegalArgumentException | ArithmeticException e) {
            System.out.println("Dentro do primeiro catch");
        }

        try {
            talvezLanceException();
        } catch (Exception e) {

        }
    }

    private static void talvezLanceException() throws SQLException, AWTException, IOException {

    }
}

//Quanto mais generico for a classe mais pra baixo ela deve estar
//SuperClasse embaixo e vai indo as subclasse pra cima
//Quanto mais especifica mais pra cima
//Quanto mais abrangantem mais pra baixo



