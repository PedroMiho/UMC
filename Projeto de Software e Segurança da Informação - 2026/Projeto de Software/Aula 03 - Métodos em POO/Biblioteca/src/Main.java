public class Main {
    public static void main(String[] args) {
        Livro harryPotter = new Livro("Harry Potter e a Pedra Filosofal" ,
                "J. K. Rowling" , 10, 69.90
        );

        Livro senhorDosAneis = new Livro("O Senhor dos Anéis: A Sociedade do Anel",
                " J. R. R. Tolkien", 10, 89.90
        );

        harryPotter.emprestaLivro(5);
        harryPotter.devolverLivro(3);

        harryPotter.exibirInformacoes();
        senhorDosAneis.exibirInformacoes();
    }
}
