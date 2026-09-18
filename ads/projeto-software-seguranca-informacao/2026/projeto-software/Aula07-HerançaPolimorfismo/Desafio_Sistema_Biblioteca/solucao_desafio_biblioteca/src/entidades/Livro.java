package entidades;

public class Livro extends ItemBiblioteca implements Emprestavel {

    private String isbn;
    private boolean disponivel;

    public Livro(String titulo, String autor, int anoPublicacao, String isbn) {
        super(titulo, autor, anoPublicacao);
        this.isbn = isbn;
        this.disponivel = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Livro");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Ano: " + getAnoPublicacao());
        System.out.println("ISBN: " + isbn);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
    }

    @Override
    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Item emprestado com sucesso");
        } else {
            System.out.println("Item indisponível para empréstimo");
        }
    }

    @Override
    public void devolver() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("Item devolvido com sucesso");
        } else {
            System.out.println("O item já está disponível");
        }
    }

    @Override
    public boolean estaDisponivel() {
        return disponivel;
    }
}
