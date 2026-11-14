package model.entidades;

public class Vendedor {
    private int idVendedor;
    private String nomeVendedor;
    private int avaliacao;

    // Construtor vazio (padrão)
    public Vendedor() {
    }

    // Construtor com todos os atributos
    public Vendedor(int idVendedor, String nomeVendedor, int avaliacao) {
        this.idVendedor = idVendedor;
        this.nomeVendedor = nomeVendedor;
        this.avaliacao = avaliacao;
    }

    // Getters e Setters
    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "idVendedor=" + idVendedor +
                ", nomeVendedor='" + nomeVendedor + '\'' +
                ", avaliacao=" + avaliacao +
                '}';
    }
}