package MaratonaJava.Oexception.test;

import java.util.Scanner;

public class Exercicio {
    private String nome = "Igor";
    private String senha = "123";
    public String nomedigitado;
    public String senhadigitada;

    public void setNomedigitado(String nomedigitado) {
        this.nomedigitado = nomedigitado;
    }

    public void setSenhadigitada(String senhadigitada) {
        this.senhadigitada = senhadigitada;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public static void main(String[] args) {
        Exercicio exercicio = new Exercicio();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome:");
        exercicio.setNomedigitado(scanner.nextLine());
        System.out.println("Digite a Senha:");
        exercicio.setSenhadigitada(scanner.nextLine());

        if (!exercicio.nomedigitado.equals(exercicio.getNome()) || !exercicio.senhadigitada.equals(exercicio.getSenha())) {
            throw new IllegalArgumentException();
        } else {
            System.out.println("Login Efetuado com Sucesso");
        }

    }
}
