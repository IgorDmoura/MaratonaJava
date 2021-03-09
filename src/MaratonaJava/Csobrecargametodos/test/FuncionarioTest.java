package MaratonaJava.Csobrecargametodos.test;

import MaratonaJava.Csobrecargametodos.classes.Funcionario;

public class FuncionarioTest {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("João","111.222.333.45",4500,"1234-5");
        funcionario.print();
    }
}

