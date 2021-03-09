package MaratonaJava.Zcolecoes.classes;

public class Celular {
    private String nome;
    private String IMEI;

    public Celular(String nome, String IMEI) {
        this.nome = nome;
        this.IMEI = IMEI;
    }

    //Para fazer método equals
    //Reflexivo - x.equals(y) tem que ser true para tudo que for diferente de null
    //Simétrico - Para x e y diferente de null, se x.equals(y) for true, logo y.equals(x) tem que ser true
    //Transitivdade - Para x, y e z diferente de null, se x.equals(y) == true, logo y.equals(x) == true e
    //e x.equals(z) tambem tem que ser true
    //Para x diferente de null, x.equals(null) tem que retornar false

    //Objetivo do Exemplo: Verificar se os dois IMEIS sao iguais pra saber se é o mesmo celular

    //Regras do método hashcode
    //Se x.equals(y) == true - y.hashcode() == x.hashcode(); - Se equals retorna true, hashcode tem que ser true
    //Usar mesmo valor de return do equals
    //y.hashcode() == x.hashcode() - Nao necessariamente o equals deverá retornar true
    //x.equals(y) == false - Retorna false
    //y.hashcode() != x.hashcode() - x.equals(y) deverá ser false


    @Override
    public int hashCode() {
        return IMEI != null ? IMEI.hashCode() : 1; // Se for diferente de nulo, retorna hashcode, se nao retorna
        //o valor 1, que é um valor constante
        //Retorna o hashcode da string marcada, nesse caso do IMEI
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false; //Se o objeto passado por nulo retorna false
        if (this == obj)
            return true; //Se o objeto na memória e objeto passado estiver no mesmo endereço de memória é true
        if (this.getClass() != obj.getClass()) return false; //Se nao for mesma classe retorna false
        Celular outroCelular = (Celular) obj; //Garantindo que é mesma classe, cast pro obj vira objeto celular
        return IMEI != null && IMEI.equals(outroCelular.getIMEI());
        //Comparandos os dois IMEIS se nao for nulo, se for nulo return false, comparando Strings

    }

    @Override
    public String toString() {
        return "Celular{" +
                "nome='" + nome + '\'' +
                ", IMEI='" + IMEI + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }
}
