package MaratonaJava.ZZBclassesinternas.test;

public class ClassesLocaisTest {
    public String nome = "Willian";

    public void fazAlgumaCoisa() {
        String sobrenome = "Suane";
        class Interna { //So pode usar abstract ou final
            public void imprimiNomeExterno() {
                System.out.println(nome);
                System.out.println(sobrenome); //Só pode usar atributos finais vindo de um método interno
                //Ou atributos efetivamente finais(Que nao so alterados no método)
            }
        }
        Interna in = new Interna(); //Pro método funciona no main tem que ter objeto fora do método
        in.imprimiNomeExterno();
    }

    public static void main(String[] args) {
        ClassesLocaisTest externa = new ClassesLocaisTest();


    }
}
