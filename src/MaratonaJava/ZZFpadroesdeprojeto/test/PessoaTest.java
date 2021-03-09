package MaratonaJava.ZZFpadroesdeprojeto.test;

import MaratonaJava.ZZFpadroesdeprojeto.classes.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa p = new Pessoa.PessoaBuilder("Willian")
                .nomeDoMeio("Suane")
                .ultimoNome("Queiroz")
                .nomeDoPai("Willian")
                .apelido("JirayaBolado")
                .build();
        System.out.println(p);
    }
}
