package MaratonaJava.ZZLstreamsparalelos;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsParalelos1 {
    public static void main(String[] args) {
        long num = 10_000_000_00;
        somaFor(num);
//        somaStreamIterate(num);
//        somaParallelStreamIterate(num);
        System.out.println(Runtime.getRuntime().availableProcessors());
        somaRangeClosedStream(num);
        somaRangeClosedParallelStream(num);


        //Mudar quantidade de threas (Nao recomendado)
        //System.out.println("java.util.concurrent.ForkJoinPool.COMMON.parallelism,"12);



    }
    //[1,2,3,4,5,6,7,8,9,10] //Paralelo separa em threads pra realizar e chegar em um resultado comum

    //Usando For
    private static void somaFor(long num) {
        System.out.println("For");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1L; i <= num; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    //Usando Stream
    private static void somaStreamIterate(long num) {
        System.out.println("Stream Sequencial");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    //Usando Stream
    private static void somaParallelStreamIterate(long num) {
        System.out.println("Stream Paralelps");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    //Usando Range Closed
    private static void somaRangeClosedStream(long num) {
        System.out.println("Range Closed Stream");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L,num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }

    //Usando Range Closed Parallel
    private static void somaRangeClosedParallelStream(long num) {
        System.out.println("Range Closed Stream Parallel");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L,num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");
    }
}

