package MaratonaJava.ZZJoptional.test;

import MaratonaJava.ZZJoptional.classes.Carro;
import MaratonaJava.ZZJoptional.classes.Pessoa;
import MaratonaJava.ZZJoptional.classes.Seguradora;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class OptionalTest2 {
    public static void main(String[] args) {
        Seguradora seguradora = new Seguradora("DevDojo Seguros");
        Carro carro = new Carro(seguradora, "Audi");
        Pessoa p = new Pessoa(carro, "Carlos");

        obterNomeSeguradora(Optional.ofNullable(p));
        checaNomeSeguradora(seguradora);
        checarNomeSeguradoraOptional(seguradora);
        p.setIdade(20);
        System.out.println(obterNomeSeguradoraComIdade(p, 18));

        Map<String, String> map = new HashMap<>();

        System.out.println(Optional.ofNullable(map.get("kaka"))); // Se usar optional retorna optional empty

        stringToInt("A");


    }

    private static Optional<Integer> stringToInt(String numero) { //Faz retornar um optional ao inves da exception e.print
        try {
            return Optional.of(Integer.parseInt("A"));

        } catch (NumberFormatException e) {
            return Optional.empty();
        }

    }

    private static void checaNomeSeguradora(Seguradora seguradora) {
        if (seguradora != null && seguradora.getNome().equals("DevDojo Seguros")) {
            System.out.println("é o devdojo");
        }
    }

    private static void checarNomeSeguradoraOptional(Seguradora seguradora) {
        Optional.ofNullable(seguradora).filter(s -> s.getNome().equals("DevDojo Seguros"))
                .ifPresent(x -> System.out.println("é o devdojo"));
    }


    public static String obterNomeSeguradora(Optional<Pessoa> p) { //Pode ou nao existir
        return p.flatMap(Pessoa::getCarro)
                .flatMap(Carro::getSeguradora)
                .map(Seguradora::getNome)
                .orElse("Nao existe Seguradora");
    }

    private static String obterNomeSeguradoraComIdade(Pessoa p, int idadeMinima) {
        return Optional.ofNullable(p)
                .filter(pessoa -> p.getIdade() >= idadeMinima)
                .flatMap(Pessoa::getCarro)
                .flatMap(Carro::getSeguradora)
                .map(Seguradora::getNome)
                .orElse("Nao existe segurada ou a idade minima nao foi atingida");
    }
}

//Flat map pega direto o valor da string
//Se usar o map pega um optional dentro de um optional
//Quando for o resultado final usar o map
//Se retornar o objeto que quer usar map
//Se retornar um optional usar flatmap