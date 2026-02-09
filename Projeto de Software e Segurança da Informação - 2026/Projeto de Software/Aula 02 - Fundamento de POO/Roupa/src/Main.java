public class Main {
    public static void main(String[] args) {

        Produto p1 = new Produto();
        p1.nome = "Produto A";
        p1.preco = 10.0;

        Produto p2 = new Produto();
        p2.nome = "Produto B";
        p2.preco = 20.0;

        p1.exibir();
        p2.exibir();
    }
}
