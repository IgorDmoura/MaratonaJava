package MaratonaJava.Kenum.classes;

public class ClienteExer {
    public enum TipoPagamaento {
        AVISTA, APRAZO
    }

    private String nome;
    private TipoClienteExer tipoClienteExer;
    private TipoPagamaento tipoPagamaento;

    public ClienteExer(String nome, TipoClienteExer tipoClienteExer, TipoPagamaento tipoPagamaento) {
        this.nome = nome;
        this.tipoClienteExer = tipoClienteExer;
        this.tipoPagamaento = tipoPagamaento;
    }

    @Override
    public String toString() {
        return "ClienteExer{" +
                "nome='" + nome + '\'' +
                ", tipoClienteExer=" + tipoClienteExer +
                ", tipoPagamaento=" + tipoPagamaento +
                " Tipo: " + tipoClienteExer.getTipo()+ " " + "nome: " +
                tipoClienteExer.getNome();
    }

    public TipoPagamaento getTipoPagamaento() {
        return tipoPagamaento;
    }

    public void setTipoPagamaento(TipoPagamaento tipoPagamaento) {
        this.tipoPagamaento = tipoPagamaento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoClienteExer getTipoClienteExer() {
        return tipoClienteExer;
    }

    public void setTipoClienteExer(TipoClienteExer tipoClienteExer) {
        this.tipoClienteExer = tipoClienteExer;
    }
}

