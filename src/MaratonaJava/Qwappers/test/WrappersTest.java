package MaratonaJava.Qwappers.test;

public class WrappersTest {
    public static void main(String[] args) {
        byte bytePrimitivo  = 1;
        short shortPrimitivo  = 1;
        int intPrimitivo  = 10;
        long longPrimitivo  = 10;
        float floatPrimitivo  = 10;
        double doublePrimitivo  = 10;
        char charPrimitivo  = 'A';
        boolean booleanPrimitivo  = true;

        Byte byteWrapper = 1; //1 até 127
        Short shortWrapper = 1;
        Integer integerWrapper = new Integer("10");  //Converte a String para número
        Long longWrapper = Long.valueOf("10"); // Retorna o Wrapper do respectvo nome, nesse caso Long
        Float floatWrapper= new Float("10");  //Converte a String para número
        Double doubleWrapper = 10D;
        Character character = 'A';
        Boolean booleanWrapper = new Boolean("true");  //Converte a String para boolean

        System.out.println(integerWrapper);

        String valor = "10";
        Float f = Float.parseFloat(valor); //Converte para a classe float o argumento
        System.out.println(f);

        System.out.println(character.isDigit('9'));// Verifica se é digito ou não
        System.out.println(character.isLetter('A'));  //Verifica se é letra ou não
        System.out.println(character.isLetterOrDigit('A'));  //Verifica se é letra ou digito
        System.out.println(character.isUpperCase('A'));  //Verifica se é maisculo ou não
        System.out.println(character.isLowerCase('A'));  //Verifica se é minusculo ou não
        System.out.println(character.toUpperCase('a'));  //Converte texto para maisculo
        System.out.println(character.toLowerCase('A'));  //Converte texto para minusculo



    }
}

