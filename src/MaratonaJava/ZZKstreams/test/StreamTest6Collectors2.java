package MaratonaJava.ZZKstreams.test;

import MaratonaJava.ZZKstreams.classes.Genero;
import MaratonaJava.ZZKstreams.classes.Maioridade;
import MaratonaJava.ZZKstreams.classes.Pessoa;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamTest6Collectors2 {
    //Agrupamento
    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        Map<Genero, List<Pessoa>> generoListMap = new HashMap<>();

        //Criar Map com Key Genero e mostrar os valores(pessoas) de cada

        List<Pessoa> masculinos = new ArrayList<>();
        List<Pessoa> femininos = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getGenero().equals(Genero.MASCULINO)) {
                masculinos.add(pessoa);
            } else {
                femininos.add(pessoa);
            }
        }

        generoListMap.put(Genero.MASCULINO, masculinos);
        generoListMap.put(Genero.FEMININO, femininos);
        System.out.println(generoListMap);

        //Forma nova de fazer isso - Utilizando groupingby e passando a key que ira agrupar
        //Agrupamento por genero:
        Map<Genero, List<Pessoa>> collect = pessoas.stream().collect(groupingBy(Pessoa::getGenero));
        System.out.println(collect);

        //Verificar maioridade utilizando o enum criado
        //Agrupamento por maioridade
        Map<Maioridade, List<Pessoa>> collect1 = pessoas.stream().collect(groupingBy(p -> {
            if (p.getIdade() < 18) return Maioridade.MENOR;
            else return Maioridade.ADULTO;
        }));
        System.out.println(collect1);

        //Agrupando por genero e tambem por maioridade no mesmo
        Map<Genero, Map<Maioridade, List<Pessoa>>> collect2 = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero, groupingBy(p -> {
                    if (p.getIdade() < 18) return Maioridade.MENOR;
                    else return Maioridade.ADULTO;
                })));
        System.out.println(collect2);

        //Agrupando por genero e quantidade
        Map<Genero, Long> collect3 = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero, Collectors.counting()));
        System.out.println(collect3);

        //Agrupando por genero e maior salario com optional
        Map<Genero, Optional<Pessoa>> collect4 = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero,
                        Collectors.maxBy(Comparator.comparing(Pessoa::getSalario))));
        System.out.println(collect4);

        //Agrupando por genero e maior salario sem optional
        //Remover o optional - Retorna uma pessoa ao inves de um optional de pessoa
        Map<Genero, Pessoa> collect5 = pessoas.stream().collect(groupingBy(Pessoa::getGenero,
                collectingAndThen(Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)),
                        Optional::get)));
        System.out.println(collect5);

        //Agrupando por genero e estatisticas
        Map<Genero, DoubleSummaryStatistics> collect6 = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero,
                        summarizingDouble(Pessoa::getSalario)));
        System.out.println(collect6);

        //Agrupamendo por genero e maioridade - ToSet
        Map<Genero, Set<Maioridade>> collect7 = pessoas.stream().collect(groupingBy(Pessoa::getGenero, mapping(p -> {
            if (p.getIdade() < 18) return Maioridade.MENOR;
            else return Maioridade.ADULTO;
        }, toSet())));
        System.out.println(collect7);

        //Agrupamendo por genero e maioridade - LinkedHashSet (Mantem a ordem)
        Map<Genero, Set<Maioridade>> collect8 = pessoas.stream().collect(groupingBy(Pessoa::getGenero, mapping(p -> {
            if (p.getIdade() < 18) return Maioridade.MENOR;
            else return Maioridade.ADULTO;
        }, toCollection(LinkedHashSet::new))));
        System.out.println(collect8);


    }
}
