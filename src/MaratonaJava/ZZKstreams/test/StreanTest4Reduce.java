package MaratonaJava.ZZKstreams.test;

import MaratonaJava.ZZKstreams.classes.Pessoa;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreanTest4Reduce {
    public static void main(String[] args) {
        //Pegar um stream e transformar em um resultado final
        Optional<Integer> reduce = getStream().reduce((x, y) -> x + y); //Soma todos os valores
        System.out.println(reduce.get());

        Integer soma = getStream().reduce(0, (x, y) -> x + y); //Soma todos os valores
        System.out.println(soma);

        Optional<Integer> soma2 = getStream().reduce(Integer::sum); //Soma todos os valores
        System.out.println(soma2);

        Integer mult = getStream().reduce(1, (x, y) -> x * y);
        System.out.println(mult); //Multiplica todos os numeros

        Optional<Integer> max = getStream().reduce((x, y) -> x > y ? x : y);
        System.out.println(max); //Imprime o valor maximo

        Optional<Integer> max2 = getStream().reduce(Integer::max);
        System.out.println(max2); //Imprime o valor maximo

        Stream<Pessoa> streamPessoa = Pessoa.bancoDePessoas().stream();
        Optional<Double> somaSalario = streamPessoa.filter(p -> p.getSalario() > 4000)
                .map(Pessoa::getSalario)
                .reduce(Double::sum);
        System.out.println(somaSalario.get());

        Double somaDouble = Pessoa.bancoDePessoas().stream().filter(p -> p.getSalario() > 4000)
                .mapToDouble(Pessoa::getSalario)
                .sum(); //Usando map to double ele vira double e pode usar o sum
        System.out.println(somaDouble);

        DoubleStream doubleStream = Pessoa.bancoDePessoas().stream().filter(p -> p.getSalario() > 4000)
                .mapToDouble(Pessoa::getSalario);
        Stream<Double> doubleStream1 = doubleStream.boxed(); //Tranforma o valor q virou double de volta em um stream

    }

    private static Stream<Integer> getStream() {
        return Arrays.asList(1, 2, 3, 4, 5, 6).stream();
    }
}
        //So pude fazer um operacao por stream
