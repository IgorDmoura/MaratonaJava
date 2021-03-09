package MaratonaJava.ZZBclassesinternas.test;

class SuperHeroi {
    public final String nome;

    public SuperHeroi(String nome) {
        this.nome = nome;
    }

    public void poder() {
        System.out.println(this.nome + " está usando seu poder");
    }

    public String getNome() {
        return nome;
    }
}

public class ClassesAnonimasExercicio {
    public static void main(String[] args) {
        SuperHeroi homemAranha = new SuperHeroi("Homem aranha") {
            public void poder() {
                System.out.println(this.getNome() + " está soltando teias");
            }
        };
        homemAranha.poder();
    }
}

