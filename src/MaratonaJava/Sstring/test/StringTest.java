package MaratonaJava.Sstring.test;

public class StringTest {
    public static void main(String[] args) {
        String nome = "William";                                      //Nome está referenciado "Willian"//Java está criando: 1 - variavel de referencia referenciando uma string no pool de string
        nome = nome.concat(" Suane"); // nome+= " Suane"                                //Agora nome ira referenciar a nova variavel Willian + Suane
        String nome2 = "Willian";                                     //Se a String existe uma igual, ela ira referenciar a mesma string na memoria
        System.out.println(nome);                                     //Ira printar o novo valor de nome obtido na linha 6
        String nome3 = new String("Catarina");                 //Java está criando: 1 - variavel de referencia//2 - um objeto do tipo string// 3 - Uma String no pool do String

                                                                         //A linha 8 é codigo desnecessário, sempre utlizar a linha 5
         String teste = "Goku";
         String teste2 = "       0123456789        ";
         System.out.println(teste.charAt(0));//Imprime a letra correspondente na string teste, indice 0 pra cima
        System.out.println(teste.equalsIgnoreCase(teste2)); // verifica se e igual ignorado maiusculo e minusculo
        System.out.println(teste.length());// mede quantas letras tem, indice 0 pra cima
        System.out.println(teste2.replace('o','a'));// subtitui uma letra por outra
        System.out.println(teste2.toLowerCase());// coloca em minusculo
        System.out.println(teste2.toUpperCase());// coloca em maiusculo
        System.out.println(teste2.substring(0,4));//Pega parte do texto escolhido, começa do primeiro numero, e vai ate um antes do segundo
        System.out.println(teste2.trim());// tira todos os espaços da string



    }

}
