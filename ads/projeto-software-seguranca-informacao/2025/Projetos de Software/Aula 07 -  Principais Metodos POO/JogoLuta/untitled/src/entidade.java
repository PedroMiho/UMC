import java.util.Random;
import java.util.Scanner;

// Classe Jogador com atributos e métodos
class Jogador {
    String nome;
    int vida;
    Random random = new Random();

    // Construtor
    public Jogador(String nome) {
        this.nome = nome;
        this.vida = 100; // vida inicial
    }

    // Método VOID -> executa um ataque e não retorna nada
    public void atacar(Jogador inimigo) {
        int dano = random.nextInt(20) + 5; // ataque entre 5 e 25
        inimigo.vida -= dano;
        if (inimigo.vida < 0) inimigo.vida = 0;
        System.out.println("🗡️ " + this.nome + " atacou causando " + dano + " de dano!");
    }

    // Método INT -> retorna a quantidade de cura
    public int gerarCura() {
        return random.nextInt(20) + 10; // cura entre 10 e 30
    }

    // Método VOID -> usa o valor de gerarCura() para recuperar vida
    public void recuperarVida() {
        int cura = gerarCura();
        this.vida += cura;
        if (this.vida > 100) this.vida = 100;
        System.out.println("💖 " + this.nome + " recuperou " + cura + " pontos de vida!");
    }

    // Método DOUBLE -> retorna a porcentagem de vida (valor decimal)
    public double calcularPorcentagemVida() {
        return (this.vida / 100.0) * 100;
    }

    // Método STRING -> retorna o status formatado do jogador
    public String verStatus() {
        return "📊 " + this.nome + ": " + this.vida + " de vida (" + calcularPorcentagemVida() + "%)";
    }

    // Método para verificar se o jogador ainda está vivo
    public boolean estaVivo() {
        return this.vida > 0;
    }
}