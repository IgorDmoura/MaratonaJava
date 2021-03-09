package MaratonaJava.ZZJoptional.test;

import java.util.Optional;

public class OptionalTest1 {
    private String nome;

    public static void main(String[] args) {
        OptionalTest1 ot = new OptionalTest1();

        //Essa string vai ser opcional, podendo ou nao existir
        //Optional evita null point exception, se usar optional na assinatura do atributo
        //O mesmo pode nao existi ou existir sem problemas

        Optional<String> optional1 = Optional.of("DevDojo"); //Dessa forma nao pode ser null
        Optional<String> optional2 = Optional.empty(); //Dessa forma pode ser null
        Optional<String> optional3 = Optional.ofNullable(ot.nome); //Usar quando nao tem certeza se é null

        //Imprimindo
        System.out.println(optional1);
        System.out.println(optional2);
        System.out.println(optional3);

        //Buscando Valores
        System.out.println(optional1.get()); //Pegar o valor, se for null da exception
        if(optional2.isPresent()) //Se for usar get verificar antes se tem algo dentro do optional
        System.out.println(optional2.get()); //Pegar o valor

        //Se existir retorna o que existe, se nao retorna a string abaixo:
        System.out.println(optional1.orElse("vazio"));
        System.out.println(optional2.orElse("vazio"));
        System.out.println(optional3.orElse("vazio"));





//        System.out.println(ot.nome.toUpperCase());
    }
}
