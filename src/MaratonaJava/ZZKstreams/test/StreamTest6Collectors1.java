package MaratonaJava.ZZKstreams.test;

import MaratonaJava.ZZKstreams.classes.Pessoa;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class StreamTest6Collectors1 {
    //1- Redução e sumarizacao de streams em um valor unico
    //2- Agrupamento de elementos
    //3- Particionamento de elementos

    //Aula 1
    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();

        //Conta quantas pessoas tem
        System.out.println(pessoas.stream().count());
        System.out.println(pessoas.stream().collect(counting()));

        //Descobre que tem maior salario
        Optional<Pessoa> max = pessoas.stream().max(comparing(Pessoa::getSalario));
        System.out.println(max.get().getSalario());

        Optional<Pessoa> collect = pessoas.stream().collect(maxBy(comparing(Pessoa::getSalario)));
        System.out.println(collect.get().getSalario());

        //Descobre que tem menor salario
        Optional<Pessoa> collect1 = pessoas.stream().collect(minBy(comparing(Pessoa::getSalario)));
        System.out.println(collect1.get().getSalario());

        //Soma de todos salarios - Com sum
        System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario).sum());

        System.out.println(pessoas.stream().collect(summingDouble(Pessoa::getSalario)));

        //Soma de todos salarios - Com average
        System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario).average());

        System.out.println(pessoas.stream().collect(averagingDouble(Pessoa::getSalario)));

        //Metodo com tudo junto - sumaraizingDouble
        DoubleSummaryStatistics collect2 = pessoas.stream().collect(summarizingDouble(Pessoa::getSalario));
        System.out.println(collect2);
        //Se nao quiser todos marca qual quer como abaixo:
        System.out.println(collect2.getMax());
        System.out.println(collect2.getCount());

        //Concatenar Strings
        System.out.println(pessoas.stream().map(Pessoa::getNome).collect(joining()));
        //Concatenar adicionando um delimitador
        System.out.println(pessoas.stream().map(Pessoa::getNome).collect(joining(", ")));



    }
}
