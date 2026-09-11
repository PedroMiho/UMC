import entidades.Conta;

public class Main {
    public static void main(String[] args) {
        Conta conta = new Conta("João Silva", 5000);

        conta.setTitular("João Silva Santos");

        System.out.println(conta.getTitular());
        System.out.println(conta.getSaldo());

    }
}
