package entidades;

public class Vendedor extends Funcionario implements Bonificavel{
    private double metaVendas;

    public Vendedor(String nome, double salario, double metaVendas) {
        super(nome, salario);
        this.metaVendas = metaVendas;
    }

    public double getMetaVendas() {
        return metaVendas;
    }

    // Método específico do vendedor
    public void realizarVenda(double valor) {
        System.out.printf("Venda realizada no valor de R$ %.2f%n", valor);
    }

    @Override
    public double calcularBonificacao() {
        return getSalario() * 0.10;
    }

    @Override
    public String toString() {
        return super.toString() +
                "metaVendas=" + metaVendas +
                '}';
    }
}
