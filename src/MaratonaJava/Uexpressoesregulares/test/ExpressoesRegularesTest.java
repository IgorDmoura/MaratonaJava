package MaratonaJava.Uexpressoesregulares.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressoesRegularesTest {
    public static void main(String[] args) {
        // \d - Busca em uma frase ou texto todos os digitos(numero)
        // \D - Busca tudo que não for digito
        // \s - Busca todos espaços em branco - \t \n \f \r
        // \S - Busca caractere que não é branco - \\s
        // \w - Busca por caracteres de palavras a-z - A-Z - digitos e o _
        // \W - Busca tudo que não for caracteres de palavra
        // [] - Busca as caracteres dentro do colchete - [abc] ou [a-cA-D] - procura do a ate c e do A ate D ou de 0 a 9
        //Quantificadores - Procuram por uma ou mais ocorrencias de determinada expressao
        // 1 - ? - 0 ou uma
        // 2 - * - 0 ou mais
        // 3 - + - 1 ou mais
        // 4 - [n,m] - n até m ocorrencias
        //5 - ( ) - Agrupar
        //6 - | - Ou
        //7 - $ - Fim de Linha
        //8 - o[v|c]o = oco, ovo
        //9 - maca[rr/c]ão = macarrão ou macacão
        // 10 - . coringa 1.3 (o ponto pode ser substituido por qualquer caractere podia ser 123 193 1x3
        // ^ [^abc] - procura qualquer coisa que nao seja abc

        int numHex= 0x100; //- Numero hexidecimal começa com 0x, 3 numeros de 0 a 9, ou 3 caracteres de a ate F, pode misturar tambem
//        String regex = "0[xX]([0-9a-f-A-F])+(\\s|$)";    //o + diz que vai repetir uma ou mais vezes oque ta nos parenteses          //Texto que vai ser procurado, ou comando metánumérico
//        String texto = "12 0x 0X 0xFFABC 0x10G 0x1";              //Local onde o regex vai ser procurado
//        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //"([\\w\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";    //o + diz que vai repetir uma ou mais vezes oque ta nos parenteses          //Texto que vai ser procurado, ou comando metánumérico
//        String texto = "fulano@hotmail.com, 102Abc@gmail.com, #@!abrao@mail.br, teste@gmail.com.br, testegmail";              //Local onde o regex vai ser procurado
//        String regex = "\\d{2}/\\d{2}/\\d{2,4}"; //"([\\w\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";    //o + diz que vai repetir uma ou mais vezes oque ta nos parenteses          //Texto que vai ser procurado, ou comando metánumérico
//        String texto = "05/10/2010 05/05/2015 1/1/01 01/05/95";     //dd/mm/yyyy     //Local onde o regex vai ser procurado
        String regex = "proj([^,])*"; //"([\\w\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";    //o + diz que vai repetir uma ou mais vezes oque ta nos parenteses          //Texto que vai ser procurado, ou comando metánumérico
        String texto = "proj1.bkp, proj1.java, proj1.class, proj1.class, projfinal.java, proj2.bkp, proj3.java, diagrama, texto, foto";     //dd/mm/yyyy     //Local onde o regex vai ser procurado
        System.out.println("Email Válido? " + "#@!abrao@mail.br".matches(regex)); // verifica se o email é valido
        Pattern pattern = Pattern.compile(regex);           // Procurar padroes, cria os padrao
        Matcher matcher = pattern.matcher(texto);           // Encontrar esses padroes no texto

        System.out.println("Texto: " + texto);
        System.out.println("Indice: 0123456789");
        System.out.println("expressão: " + matcher.pattern());
        System.out.println("posições encontradas: ");
        while(matcher.find()){                                 // Enquanto encontrar padroes
            System.out.println(matcher.start() + " " + matcher.group());           //Start:salva padroes // Group: mostra resultado
        }
    }
}
