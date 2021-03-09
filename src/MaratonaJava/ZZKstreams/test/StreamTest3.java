package MaratonaJava.ZZKstreams.test;

import MaratonaJava.ZZKstreams.classes.Pessoa;

import java.util.Comparator;
import java.util.List;

public class StreamTest3 {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        System.out.println(pessoas.stream().anyMatch(p -> p.getSalario() > 4000)); //Verifica se a condicao e verdadeira
        System.out.println(pessoas.stream().allMatch(pessoa -> pessoa.getIdade() > 18)); //Verifica se todos sao maior que 18
        System.out.println(pessoas.stream().noneMatch(pessoa -> pessoa.getIdade() < 18)); //Verifica se nenhum deles é oque ta marcado
        pessoas.stream().filter(p -> p.getIdade() < 25)
                .findAny() //Seleciona qualquer elemento que encaixe no filter
                .ifPresent(p -> System.out.println(p.getNome()));

        pessoas.stream()
                .filter(pessoa -> pessoa.getIdade() > 30)
                .sorted(Comparator.comparing(Pessoa::getIdade).reversed())
                .findFirst() //Acha a primeira pessoa que tem a idade menor que 30 anos
                .ifPresent(p -> System.out.println(p.getNome()));

    }


}
