package controller;

import model.DAO.VendedorDAO;
import model.entidades.Vendedor;
import java.util.List;

public class VendedorController {
    private VendedorDAO vendedorDAO;

    public VendedorController() {
        this.vendedorDAO = new VendedorDAO();
    }

    // Cadastrar um novo vendedor
    public void cadastrarVendedor(int id, String nome, int avaliacao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do vendedor não pode ser vazio.");
        }
        if (avaliacao < 0 || avaliacao > 5) {
            throw new IllegalArgumentException("A avaliação deve ser um valor entre 0 e 5.");
        }

        Vendedor vendedor = new Vendedor(id, nome, avaliacao);
        vendedorDAO.cadastrar(vendedor);
    }

    // Listar todos os vendedores
    public List<Vendedor> listarVendedores() {
        return vendedorDAO.listarTodos();
    }

    // Atualizar dados de um vendedor
    public void atualizarVendedor(int id, String nome, int avaliacao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do vendedor não pode ser vazio.");
        }
        if (avaliacao < 0 || avaliacao > 5) {
            throw new IllegalArgumentException("A avaliação deve ser um valor entre 0 e 5.");
        }

        Vendedor vendedor = new Vendedor(id, nome, avaliacao);
        vendedorDAO.atualizar(vendedor);
    }

    // Deletar um vendedor pelo ID
    public void deletarVendedor(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de vendedor inválido.");
        }
        vendedorDAO.deletar(id);
    }
}