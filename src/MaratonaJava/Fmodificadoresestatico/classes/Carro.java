package MaratonaJava.Fmodificadoresestatico.classes;

public class Carro {
    private String nome;
    private double velocidadeMaxima;
    public static double velocidadeLimite = 240; //Static é o mesmo valor pra todos os objetos, o valor é da classe

    public void imprime() {
        System.out.println("_______________________");
        System.out.println("Nome: " + this.nome);
        System.out.println("Velocidade Máxima: " + this.velocidadeMaxima);
        System.out.println("Velocidade Limite: " + velocidadeLimite); // Static nao usa this porque pertence
        // a classe, e nao ao objeto 
    }

    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public Carro() {
    }

    public static void setVelocidadeLimite(double velocidadeLimite) {
        Carro.velocidadeLimite = velocidadeLimite; // Carro.velocidade limite refere-se ao atributo da classe la emcima
    }

    public static double getVelocidadeLimite() {
        return velocidadeLimite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidaMaxima) {
        this.velocidadeMaxima = velocidaMaxima;
    }
}
