package entidades;

public class Gerente extends Funcionario implements Bonificavel{
    private String setor;

    public Gerente(String nome, double salario, String setor) {
        super(nome, salario);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void realizarReuniao() {
        System.out.println("Gerente realizando reunião do setor: " + setor);
    }


    @ Override
    public double calcularBonificacao() {
        return getSalario() * 0.20;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Gerente{" +
                "setor='" + setor + '\'' +
                '}';
    }
}
