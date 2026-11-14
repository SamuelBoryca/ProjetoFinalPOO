package model.entidades;

public class Produto {
    private int idProduto;
    private String nomeProduto;
    private int quantidade;
    private double preco;
    private int idVendedor; // NOVO ATRIBUTO

    // Construtor vazio
    public Produto() {
    }

    // Construtor com todos os atributos (incluindo idVendedor)
    public Produto(int idProduto, String nomeProduto, int quantidade, double preco, int idVendedor) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.idVendedor = idVendedor;
    }

    // Getters e Setters existentes...
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public String getNomeProduto() { return nomeProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    // NOVOS GETTERS E SETTERS PARA O VENDEDOR
    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                ", idVendedor=" + idVendedor +
                '}';
    }
}