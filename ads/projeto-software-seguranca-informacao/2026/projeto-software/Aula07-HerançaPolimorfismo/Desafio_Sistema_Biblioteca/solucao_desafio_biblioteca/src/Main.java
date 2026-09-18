import entidades.Baixavel;
import entidades.Ebook;
import entidades.Emprestavel;
import entidades.ItemBiblioteca;
import entidades.Livro;
import entidades.Revista;

public class Main {

    public static void main(String[] args) {

        Livro livro1 = new Livro(
                "Java para Iniciantes",
                "Ana Lima",
                2025,
                "978-00-0000-000-0"
        );

        Livro livro2 = new Livro(
                "Programação Orientada a Objetos",
                "Carlos Souza",
                2024,
                "978-11-1111-111-1"
        );

        Revista revista = new Revista(
                "Tecnologia Hoje",
                "Editora Digital",
                2026,
                15
        );

        Ebook ebook = new Ebook(
                "Introdução ao Spring Boot",
                "Mariana Alves",
                2026,
                8.5
        );

        ItemBiblioteca item1 = livro1;
        ItemBiblioteca item2 = livro2;
        ItemBiblioteca item3 = revista;
        ItemBiblioteca item4 = ebook;

        System.out.println("=== ITENS DA BIBLIOTECA ===");
        item1.exibirInformacoes();
        System.out.println();
        item2.exibirInformacoes();
        System.out.println();
        item3.exibirInformacoes();
        System.out.println();
        item4.exibirInformacoes();

        Emprestavel emprestavel1 = livro1;
        Emprestavel emprestavel2 = revista;

        System.out.println("\n=== EMPRÉSTIMO DO LIVRO ===");
        System.out.println("Disponível antes: " + emprestavel1.estaDisponivel());
        emprestavel1.emprestar();
        emprestavel1.emprestar();
        System.out.println("Disponível depois: " + emprestavel1.estaDisponivel());
        emprestavel1.devolver();

        System.out.println("\n=== EMPRÉSTIMO DA REVISTA ===");
        emprestavel2.emprestar();
        emprestavel2.devolver();
        emprestavel2.devolver();

        System.out.println("\n=== DOWNLOAD DO EBOOK ===");
        Baixavel arquivoDigital = ebook;
        arquivoDigital.baixar();
    }
}
