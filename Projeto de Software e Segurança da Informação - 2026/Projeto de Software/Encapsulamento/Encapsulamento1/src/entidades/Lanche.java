package entidades;

public class Lanche {
    private String lanche;
    private String descricao;
    private double valorLanche;
    private int estoque;
    private boolean disponivel;


    public Lanche(String lanche, String descricao, double valorLanche, int estoque) {
        this.lanche = lanche;
        this.descricao = descricao;
        this.valorLanche = valorLanche;
        this.estoque = estoque;
        if (estoque >= 0){
            this.disponivel = true;
        } else {
            this.disponivel = false;
        }
    }

    public String getLanche() {
        return lanche;
    }

    public void setLanche(String lanche) {
        this.lanche = lanche;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorLanche() {
        return valorLanche;
    }

    public void setValorLanche(double valorLanche) {
        this.valorLanche = valorLanche;
    }

    public int getEstoque() {
        return estoque;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void decrementaQuantidade(int quantidadePedida) {
        if (quantidadePedida > this.estoque){
            System.out.println("Quantidade solicitada não disponivel");
        } else if (quantidadePedida < 1){
            System.out.println("Quantidade deve ser maior ou igual a 1");
        } else {
            this.estoque -= quantidadePedida;

            System.out.println("Você pediu " + quantidadePedida + " " + this.lanche
                    + "o valor final foi de R$ " + this.valorLanche * quantidadePedida);
            if (this.estoque == 0) {
                this.disponivel = false;
            }
        }
    }

    public void incrementarQuantiodade(int quantidade){
        this.estoque += quantidade;
        if (this.estoque > 0) {
            this.disponivel = true;
        }

    }




    @Override
    public String toString() {
        return "Lanche: " + lanche +
                "\nDescricao: " + descricao +
                "\nValor Lanche: R$ " + valorLanche +
                "\nEstoque: " + estoque +
                "\nDisponível: " + disponivel;
    }
}
