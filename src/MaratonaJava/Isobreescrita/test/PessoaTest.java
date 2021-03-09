package MaratonaJava.Isobreescrita.test;

import MaratonaJava.Isobreescrita.classes.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Joaquina na Esquina");
        p.setIdade(300);
        System.out.println(p);
        Pessoa p2 = new Pessoa();
        p2.setNome("João na Esquina");
        p2.setIdade(200);
        System.out.println(p2);
    }
}
