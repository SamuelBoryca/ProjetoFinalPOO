package model.DAO;

import model.DAO.ConexaoDB;
import model.entidades.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    // CREATE - Cadastrar um novo produto vinculado a um vendedor
    public void cadastrar(Produto produto) {
        String sql = "INSERT INTO produto (id_produto, nome_produto, quantidade, preco, id_vendedor) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produto.getIdProduto());
            stmt.setString(2, produto.getNomeProduto());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getIdVendedor());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar produto: " + e.getMessage(), e);
        }
    }

    // READ - Listar todos os produtos de um vendedor específico
    public List<Produto> listarPorVendedor(int idVendedor) {
        String sql = "SELECT * FROM produto WHERE id_vendedor = ?";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVendedor);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setIdProduto(rs.getInt("id_produto"));
                    p.setNomeProduto(rs.getString("nome_produto"));
                    p.setQuantidade(rs.getInt("quantidade"));
                    p.setPreco(rs.getDouble("preco"));
                    p.setIdVendedor(rs.getInt("id_vendedor"));
                    produtos.add(p);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos do vendedor: " + e.getMessage(), e);
        }

        return produtos;
    }

    // UPDATE - Atualizar dados de um produto existente
    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET nome_produto = ?, quantidade = ?, preco = ? WHERE id_produto = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getIdProduto());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage(), e);
        }
    }

    // DELETE - Remover um produto pelo ID
    public void deletar(int idProduto) {
        String sql = "DELETE FROM produto WHERE id_produto = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto: " + e.getMessage(), e);
        }
    }
}