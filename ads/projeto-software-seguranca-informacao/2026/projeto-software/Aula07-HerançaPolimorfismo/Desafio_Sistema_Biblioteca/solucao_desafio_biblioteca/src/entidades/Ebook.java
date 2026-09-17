package entidades;

public class Ebook extends ItemBiblioteca implements Baixavel {

    private double tamanhoArquivoMb;

    public Ebook(String titulo, String autor, int anoPublicacao, double tamanhoArquivoMb) {
        super(titulo, autor, anoPublicacao);
        this.tamanhoArquivoMb = tamanhoArquivoMb;
    }

    public double getTamanhoArquivoMb() {
        return tamanhoArquivoMb;
    }

    public void setTamanhoArquivoMb(double tamanhoArquivoMb) {
        this.tamanhoArquivoMb = tamanhoArquivoMb;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Ebook");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Ano: " + getAnoPublicacao());
        System.out.println("Tamanho do arquivo: " + tamanhoArquivoMb + " MB");
    }

    @Override
    public void baixar() {
        System.out.println("Download do ebook iniciado");
    }
}
