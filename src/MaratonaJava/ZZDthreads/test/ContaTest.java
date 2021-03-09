package MaratonaJava.ZZDthreads.test;

import MaratonaJava.ZZDthreads.classes.Conta;

public class ContaTest implements Runnable {
    private Conta conta = new Conta();

    //Todos objeto tem um lock, como se fosse uma chave, quando voce usa o
    //synchronized o lock é usado, e quando um objeto está utilizando método é criado
    //uma chave pro objeto, e só quem tem a chave pode usar o método.
    //Mesmo que outro objeto tente usar o método, nao conseguira pois nao tem a chave
    //1 lock por objeto

    //synchronized pode usar em métodos ou em blocos (Nao utilizar em classes e variavevis)
    //A primeira thread que acessar o método sincronizado fica com a chave(lock)
    //Pode ter classes com métodos sincronizados e nao sincronizados:
    //Uma thread pode ter mais de 1 lock, mas um objeto só pode ter 1 lock

    public static void main(String[] args) {
        ContaTest contaTest = new ContaTest();
        Thread willian = new Thread(contaTest, "Willian");
        Thread anna = new Thread(contaTest, "Anna");
        willian.start();
        anna.start();
    }

    public static void imprime(){ //Se colocar no método estatico um synchronized, toda a  classe fica synchronized
        synchronized (ContaTest.class){
            System.out.println("asasaa");
        }
    }

    private void saque(int valor) { //Apenas uma thread por vez pode acessar
        synchronized (conta) { //Pode colocar synchronized no método ou em um bloco
            if (conta.getSaldo() >= valor) {
                System.out.println(Thread.currentThread().getName() + " está indo sacar");
                conta.saque(valor);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " completou o saque" + " saldo: " + conta.getSaldo());
            } else {
                System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + " efetuar o saque - saldo: " + conta.getSaldo());
            }
        }
    }

        @Override
        public void run () {
            for (int i = 0; i < 5; i++) {
                saque(10);
                if (conta.getSaldo() < 0) {
                    System.out.println("Oh meu Deus!!!");
                }
            }

        }
    }

//Sincronismo de código: Nenhum thread pode acessar algo ao mesmo tempo
