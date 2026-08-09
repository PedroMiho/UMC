import java.util.Scanner;

// Classe principal que organiza o jogo
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando os jogadores
        Jogador jogador = new Jogador("Herói");
        Jogador inimigo = new Jogador("Inimigo Misterioso");

        System.out.println("🔥 Bem-vindo ao Jogo de Luta! 🔥");
        System.out.println(jogador.verStatus());
        System.out.println(inimigo.verStatus());

        // Loop do jogo
        while (jogador.estaVivo() && inimigo.estaVivo()) {
            System.out.println("\nEscolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Recuperar Vida");
            System.out.println("3 - Ver Status");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    jogador.atacar(inimigo);
                    break;
                case 2:
                    jogador.recuperarVida();
                    break;
                case 3:
                    System.out.println(jogador.verStatus());
                    System.out.println(inimigo.verStatus());
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            // Turno do inimigo (se ainda estiver vivo)
            if (inimigo.estaVivo() && escolha != 3) {
                inimigo.atacar(jogador);
            }
        }

        // Resultado final
        if (jogador.estaVivo()) {
            System.out.println("\n🎉 " + jogador.nome + " venceu a batalha!");
        } else {
            System.out.println("\n💀 " + jogador.nome + " foi derrotado!");
        }

        scanner.close();
    }
}