package MaratonaJava.ZZIdefault.interfaces;

public interface MyList {
    //Na versao 8 agora pode por metodos estaticos na interface
    static void sort(){
        System.out.println("dentro do sort");
    }

    //Pode utilizar metodos concretos
    void add();
    //Se usar default nao precisa obrigatoriamente implementar esse método
    default void remove(){
        System.out.println("dentro do remove");
    }
}

//Classe abstrata so pode extender em um classe e ainda pode utilizar varivaveis de instancia
//Interface pode utilizar metodos adicionais
