package MaratonaJava.Zcolecoes.classes;

import java.util.Objects;

public class Produto implements Comparable<Produto> {
    private String serialNumber;
    private String nome;
    private Double preço;
    private int quantidade;

    public Produto(String serialNumber, String nome, double preço) {
        this.serialNumber = serialNumber;
        this.nome = nome;
        this.preço = preço;
    }

    public Produto(String serialNumber, String nome, Double preço, int quantidade) {
        this.serialNumber = serialNumber;
        this.nome = nome;
        this.preço = preço;
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(serialNumber, produto.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "serialNumber='" + serialNumber + '\'' +
                ", nome='" + nome + '\'' +
                ", preço=" + preço +
                ", quantidade=" + quantidade +
                '}';
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    @Override
    public int compareTo(Produto outroObjeto) {
        //Vai retornar um INT
        //Esse Int vai ser um numero negativo se thus.object < outroobjeto
        //Vai retornar 0 se this.object = outroobjeto
        //This = Objeto que estamo - Outroobjeto = Objeto que sera passado no método compareTO
        //Vai retornar positivo se this.objeto > outroobjeto
        Double d = preço;
        return this.preço.compareTo(outroObjeto.getPreço()); //Compara os 2 serials
        //Pode mudar e comparar com qual atributo quiser
        //A lista será ordenada por ondem alfabética ou numerica dependendo do que for comparado aqui
        //Não é possivel compara atributos primitivos,a nao ser que transforme o atributo, pois eles nao tem metodos
        //Se mudar de um double primitivo para um Double, ai pode fazer normal
        //Tambem da certo se criar variavel no metodo e fazer ela receber o preço - Double d = preço;
    }
}
