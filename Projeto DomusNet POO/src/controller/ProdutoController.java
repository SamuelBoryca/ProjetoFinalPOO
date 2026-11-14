package controller;

import model.DAO.ProdutoDAO;
import model.entidades.Produto;
import java.util.List;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
    }

    // Cadastrar um novo produto
    public void cadastrarProduto(int idProduto, String nomeProduto, int quantidade, double preco, int idVendedor) {
        if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        if (idVendedor <= 0) {
            throw new IllegalArgumentException("ID do vendedor inválido para vincular o produto.");
        }

        Produto produto = new Produto(idProduto, nomeProduto, quantidade, preco, idVendedor);
        produtoDAO.cadastrar(produto);
    }

    // Listar produtos filtrados por vendedor
    public List<Produto> listarProdutosPorVendedor(int idVendedor) {
        if (idVendedor <= 0) {
            throw new IllegalArgumentException("ID de vendedor inválido.");
        }
        return produtoDAO.listarPorVendedor(idVendedor);
    }

    // Atualizar dados de um produto
    public void atualizarProduto(int idProduto, String nomeProduto, int quantidade, double preco) {
        if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }

        // Mantém o ID original e atualiza os demais campos (o ID do vendedor permanece o mesmo no banco)
        Produto produto = new Produto();
        produto.setIdProduto(idProduto);
        produto.setNomeProduto(nomeProduto);
        produto.setQuantidade(quantidade);
        produto.setPreco(preco);

        produtoDAO.atualizar(produto);
    }

    // Deletar um produto pelo ID
    public void deletarProduto(int idProduto) {
        if (idProduto <= 0) {
            throw new IllegalArgumentException("ID de produto inválido.");
        }
        produtoDAO.deletar(idProduto);
    }
}