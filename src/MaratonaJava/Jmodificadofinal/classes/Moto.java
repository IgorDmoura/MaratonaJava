package MaratonaJava.Jmodificadofinal.classes;

public class Moto {
    private final String nomeMoto = "Honda";
    private final CompradorMoto compradorMoto = new CompradorMoto();

    @Override
    public String toString() {
        return "Moto{" +
                "nomeMoto='" + nomeMoto + '\'' +
                ", compradorMoto=" + compradorMoto +
                '}';
    }

    public String getNomeMoto() {
        return nomeMoto;
    }

    public CompradorMoto getCompradorMoto() {
        return compradorMoto;
    }

}
