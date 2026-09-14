package entidades;

public class Estagiario extends Funcionario {
    private String instituicaoEnsino;

    public Estagiario(
            String nome,
            double salario,
            String instituicaoEnsino
    ) {
        super(nome, salario);
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public String getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    // Método específico do estagiário
    public void estudar() {
        System.out.println(
                "Estagiário estudando na instituição: "
                        + instituicaoEnsino
        );
    }

    @Override
    public String toString() {
        return super.toString() +
                "Estagiario{" +
                "instituicaoEnsino='" + instituicaoEnsino + '\'' +
                '}';
    }
}
