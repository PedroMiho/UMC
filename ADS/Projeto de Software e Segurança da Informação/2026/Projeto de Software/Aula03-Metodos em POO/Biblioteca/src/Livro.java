public class Livro {
    String titulo;
    String autor;
    int quantidade;
    double valorLivro;

    //Construtor
    public Livro(String titulo, String autor, int quantidade, double valorLivro) {
        this.titulo = titulo;
        this.autor = autor;
        this.quantidade = quantidade;
        this.valorLivro = valorLivro;
    }

    //Metodo Empresta Livro
    public void emprestaLivro(int quantidade){
        if (quantidade > 0 && quantidade <= this.quantidade){
            this.quantidade -=  quantidade;
        } else {
            System.out.println("Informe uma quantidade válida");
        }
    }

    //Metodo Devolve livro
    public void devolverLivro(int quantidade){
        if (quantidade > 0){
            this.quantidade +=  quantidade;
        } else {
            System.out.println("Informe uma quantidade válida");
        }
    }

    public double valorTotal(){
        return this.valorLivro * this.quantidade;
    }

    //Exibir as Informações do livro
    public void exibirInformacoes(){
        System.out.println("Titulo: " + this.titulo +
                "\nAutor: " + this.autor +
                "\nQuantidade: " + this.quantidade +
                "\nValor do livro: R$ " + this.valorLivro +
                "\nValor Total: R$ " + valorTotal()
        );
    }




}
