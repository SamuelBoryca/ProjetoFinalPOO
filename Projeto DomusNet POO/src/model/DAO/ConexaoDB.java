package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/MarketPlace?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root"; // Altere conforme o seu usuário do MySQL
    private static final String SENHA = "#senha123";     // Insira sua senha do MySQL aqui

    public static Connection conectar() {
        try {
            // Garante que o driver do MySQL está carregado (opcional para versões mais recentes, mas boa prática)
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do MySQL não encontrado no classpath!", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados MarketPlace!", e);
        }
    }
}