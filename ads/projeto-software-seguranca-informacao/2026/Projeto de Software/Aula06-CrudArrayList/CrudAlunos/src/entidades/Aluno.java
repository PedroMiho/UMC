package entidades;

public class Aluno {
    private String nome;
    private double nota1;
    private double nota2;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double mediaAluno(){
        return (this.nota1 + this.nota2)/2;
    }

    public String statusAluno(){
        if(mediaAluno() >= 7){
            return "Aprovado";
        } else if(mediaAluno() >= 5) {
            return "Exame";
        } else {
            return "Reprovado";
        }
    }

    @Override
    public String toString() {
        return " | " + nome + " | " + nota1 + " | " + nota2 + " | " +  mediaAluno() + " | " +  statusAluno() + " | ";
    }
}
