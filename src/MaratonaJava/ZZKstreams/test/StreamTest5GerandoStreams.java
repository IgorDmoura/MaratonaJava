package MaratonaJava.ZZKstreams.test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest5GerandoStreams {
    public static void main(String[] args) {
        //Faz stream sequencia de todos numeros incluindo o ultimo
        IntStream.rangeClosed(1,50).filter(n-> n % 2 ==0).forEach(s-> System.out.print(s+ " "));
        System.out.println();
        //Faz stream sequencia de todos numeros excluindo o ultimo
        IntStream.range(1,50).filter(n-> n % 2 ==0).forEach(s-> System.out.print(s+ " "));

        //Cria Stream de palavra
        Stream<String> stringStream = Stream.of("Willian", "DevDojo", "Acessem o Facebook pelo amorde Deus e curtam");
        System.out.println();

        //Deixa tudo(Map) - maiusclo (uppercase)
        stringStream.map(String::toUpperCase).forEach(s-> System.out.print(s+ " "));

        //Criar stream vazio
        Stream<String> empty = Stream.empty();

        //Criar InTStream a partir de um array
        int nums[] = {1,2,3,4,5};
        OptionalDouble average = Arrays.stream(nums).average();
        System.out.println(average.getAsDouble());

        //Pegar palavras de um arquivo com stream
        try(Stream<String> lines = Files.lines(Paths.get("Teste.txt"), Charset.defaultCharset())){
            lines.flatMap(line -> Arrays.stream(line.split("\n")))
                    .filter(p-> p.contains("File"))
                    .forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }

        //Streams infinitos - Iterate
        Stream.iterate(1, n-> n + 2) //O n é o 1, começa com 1 soma 2 durante o percusso
                .limit(10) //Limita a 10 iteracoes
                .forEach(System.out::println);

        //Sequencia fibonnaci: 0,1,1,2,3,5,8,13,21,34
        // (0,1) (1,1) (1,2) (2,3) (3,5) (5,8)
        Stream.iterate(new int[] {0,1}, a-> new int[]{a[1],a[0]+a[1]})
                .limit(5)
                .forEach(t-> System.out.println(Arrays.toString(t)));

        Stream.iterate(new int[] {0,1}, a-> new int[]{a[1],a[0]+a[1]})
                .limit(10)
                .map(t->t[0])
                .forEach(System.out::println);

        //Streams infinitos - Generate
        Stream.generate(Math::random) //Gera numeros aleatorios
                .limit(10)
                .forEach(System.out::println);

        ThreadLocalRandom t= ThreadLocalRandom.current();
        Stream.generate(()-> t.nextInt(1,100)).
                limit(100)
                .forEach(System.out::println);







    }
}
