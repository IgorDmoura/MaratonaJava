package MaratonaJava.ZZBclassesinternas.test;

class Externa {
    private static String nome;

    static class Interna { //Sao como se fosse membros estaticos
        public void imprimir() {
            System.out.println("oi");
//            System.out.println(nome); //So pode acessar atributo em classe estatica se atributo for estatico
        }
    }
}
//Pra chamar classe interna no metodo main:

public class ClassesInternasEstaticasTest {
    public static void main(String[] args) {
        Externa.Interna teste = new Externa.Interna(); //Chamar Classe Estatica Interna
        teste.imprimir();
        Interna2 teste2 = new Interna2(); //Chamar Classe Estatica Interna dentro da class public
        teste2.imprimir();
    }

    static class Interna2 {
        public void imprimir() {
            System.out.println("oi dentro do interna 2");
        }
    }
}
