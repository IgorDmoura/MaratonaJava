package MaratonaJava.Oexception.test;

import MaratonaJava.Oexception.customException.LoginInvalidoException;

public class CustomExceptionTest {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }

    private static void logar() throws LoginInvalidoException{
        String usuario = "Goku";
        String senha = "111";
        String usuariodigitado = "Goku";
        String senhadigitada = "112";
        if (!usuario.equals(usuariodigitado) || !senha.equals(senhadigitada)) {
            throw new LoginInvalidoException();
        } else {
            System.out.println("Login realizado com sucesso");
        }
    }
}

