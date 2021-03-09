package MaratonaJava.ZZMcompletablefuture.classes;

public class Orcamento {
    private final String nomeLoja;
    private final double preco;
    private final Desconto.Codigo codigoDesconto;

    private Orcamento(String nomeLoja, double preco, Desconto.Codigo codigoDesconto) {
        this.nomeLoja = nomeLoja;
        this.preco = preco;
        this.codigoDesconto = codigoDesconto;
    }
    //Separa a string, pelos : (regex), e pega valores pelo indice
    public static Orcamento parse(String s){
        String[] split = s.split(":");
        String nomeLoja = split[0];
        double preço = Double.parseDouble(split[1]);
        Desconto.Codigo codigoDesconto = Desconto.Codigo.valueOf(split[2]);
        return new Orcamento(nomeLoja, preço, codigoDesconto);
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public double getPreco() {
        return preco;
    }

    public Desconto.Codigo getCodigoDesconto() {
        return codigoDesconto;
    }
}
