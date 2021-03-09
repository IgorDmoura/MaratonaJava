package MaratonaJava.Hheranca.test;

import MaratonaJava.Hheranca.classes.Endereco;
import MaratonaJava.Hheranca.classes.Funcionario;
import MaratonaJava.Hheranca.classes.Pessoa;

public class HerancaTest {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Gina");
        Endereco end = new Endereco();
        p.setCpf("114.354.654.98");
        end.setRua("Rua Edson Carlos Kuntze");
        end.setBairro("Paranaguamirim");
        p.setEndereco(end);
        p.imprime();
        System.out.println("-----------------------------------");
        Funcionario f = new Funcionario("Augusto");
        f.setCpf("115.694.987.54");
        f.setSalario(15000);
        f.setEndereco(end);
        f.imprime();
    }
}
