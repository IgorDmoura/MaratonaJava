package MaratonaJava.Sstring.test;

public class StringBuilderTest {
    public static void main(String[] args) {
        String a = "Uma frase comum";
        StringBuilder abc = new StringBuilder(5);//Ao atingir o limite ele dobra
        abc.append("Uruguai");
        System.out.println(abc);
        abc.reverse();
        abc.reverse();//Inverte a String
        System.out.println(abc);
        abc.delete(0,2);//Apaga parte da string -- deleta o primeiro até o antes do ultimo
        System.out.println(abc);
        abc.insert(2,"abc"); // insere algo na string - começa contando do 1
        System.out.println(abc);
        StringBuilder sb = new StringBuilder();
        sb.append("def").insert(3,"ghi").reverse().delete(2,4);
        System.out.println(sb);

        //Se mudar tudo pra STRINGBUFFER DA NO MESMO, É MESMO COISA
        //Diferença é que no StrinBuffer os métodos são sincronizados
        //Mas nao muda nada

    }
}
