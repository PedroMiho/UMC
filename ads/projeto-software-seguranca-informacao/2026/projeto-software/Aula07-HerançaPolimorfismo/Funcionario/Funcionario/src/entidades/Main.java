package entidades;
public class Main {

    public static void main(String[] args) {

        Gerente gerente = new Gerente("Ana", 5000, "Tecnologia");
        Vendedor vendedor = new Vendedor("Carlos", 3000, 20000);
        Estagiario estagiario = new Estagiario("Julia", 1500, "UMC");

        System.out.println(gerente.toString());
        System.out.println("Bonificação do gerente: R$ "
                + gerente.calcularBonificacao());

        System.out.println();

        System.out.println(vendedor.toString());
        System.out.println("Bonificação do vendedor: R$ "
                + vendedor.calcularBonificacao());

        System.out.println(estagiario.toString());

    }
}