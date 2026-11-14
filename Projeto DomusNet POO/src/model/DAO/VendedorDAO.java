package model.DAO;

import model.DAO.ConexaoDB;
import model.entidades.Vendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {

    // CREATE - Cadastrar um novo vendedor
    public void cadastrar(Vendedor vendedor) {
        String sql = "INSERT INTO vendedor (id_vendedor, nome_vendedor, avaliacao) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vendedor.getIdVendedor());
            stmt.setString(2, vendedor.getNomeVendedor());
            stmt.setInt(3, vendedor.getAvaliacao());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar vendedor: " + e.getMessage(), e);
        }
    }

    // READ - Listar todos os vendedores
    public List<Vendedor> listarTodos() {
        String sql = "SELECT * FROM vendedor";
        List<Vendedor> vendedores = new ArrayList<>();

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setIdVendedor(rs.getInt("id_vendedor"));
                v.setNomeVendedor(rs.getString("nome_vendedor"));
                v.setAvaliacao(rs.getInt("avaliacao"));
                vendedores.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vendedores: " + e.getMessage(), e);
        }

        return vendedores;
    }

    // UPDATE - Atualizar dados de um vendedor existente
    public void atualizar(Vendedor vendedor) {
        String sql = "UPDATE vendedor SET nome_vendedor = ?, avaliacao = ? WHERE id_vendedor = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vendedor.getNomeVendedor());
            stmt.setInt(2, vendedor.getAvaliacao());
            stmt.setInt(3, vendedor.getIdVendedor());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar vendedor: " + e.getMessage(), e);
        }
    }

    // DELETE - Remover um vendedor pelo ID
    public void deletar(int idVendedor) {
        String sql = "DELETE FROM vendedor WHERE id_vendedor = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVendedor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar vendedor: " + e.getMessage(), e);
        }
    }
}