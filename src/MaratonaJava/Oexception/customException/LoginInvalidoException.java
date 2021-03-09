package MaratonaJava.Oexception.customException;

public class LoginInvalidoException extends Exception {

    public LoginInvalidoException(){
        super("Usuario ou senha inválidos");
    }
}



