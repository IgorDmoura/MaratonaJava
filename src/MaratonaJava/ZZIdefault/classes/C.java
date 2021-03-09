package MaratonaJava.ZZIdefault.classes;

import MaratonaJava.ZZIdefault.interfaces.A;
import MaratonaJava.ZZIdefault.interfaces.B;

public class C implements A, B {
    public static void main(String[] args) {
        new C().oi();
        //Regras pra multiplica herenca
        //Uma método em uma classe tem preferencia quanto a um metodo default de uma interface
        //dentro do oi de A na classe D

        //Caso tenha o tipo de metodo de mesma assinatura, é executado o método mais espeficico
        //Exemplo: O b extends A, ou seja b é mais especifico que A, entao B tem prioridade

        //Opcao ambigua, se herdar de multiplas interfaces, escolher uma delas
        //public class C implements A, B  - Escolher uma
        //Escolhe uma criando método com o suoer

    }
    public void oi(){
        B.super.oi();
    }
}
