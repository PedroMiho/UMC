package entidades;

public class Gato {
    private String nome;
    private int idade;
    private double peso;
    private String cor;

    public Gato(String nome, int idade, double peso, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", cor='" + cor + '\'' +
                '}';
    }
}
