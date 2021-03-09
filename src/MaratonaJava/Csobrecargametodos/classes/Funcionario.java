package MaratonaJava.Csobrecargametodos.classes;

public class Funcionario {
    private String nome;
    private String cpf;
    private double salario;
    private String rg;

    public Funcionario(String nome, String cpf, double salario, String rg){
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.rg = rg;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getRg() {
        return this.rg;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public double getSalario() {
        return this.salario;
    }

    public void print() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Salário: " + this.salario);
        System.out.println("RG: " + this.rg);
    }

    public void init(String nome, String cpf, double salario){
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }
    public void init(String nome, String cpf, double salario, String rg){
        init(nome,cpf,salario);
        this.rg= rg;
    }
}






