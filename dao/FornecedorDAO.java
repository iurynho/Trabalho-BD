package dao;

import java.sql.*;

public class FornecedorDAO {
    private Connection conn;

    public FornecedorDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserirFornecedor(String nome, String contato) throws SQLException {
        String sql = "INSERT INTO fornecedores (nome, contato) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, contato);
            stmt.executeUpdate();
            System.out.println("Fornecedor inserido com sucesso.");
        }
    }

    public void listarFornecedores() throws SQLException {
        String sql = "SELECT * FROM fornecedores";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | Nome: %s | CONTATO: %s\n",
                        rs.getInt("id_fornecedor"),
                        rs.getString("nome"),
                        rs.getString("contato"));
            }
        }
    }

    public void atualizarFornecedor(int idFornecedor, String novoNome) throws SQLException {
        String sql = "UPDATE fornecedores SET nome = ? WHERE id_fornecedor = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoNome);
            stmt.setInt(2, idFornecedor);
            stmt.executeUpdate();
            System.out.println("Fornecedor atualizado com sucesso.");
        }
    }

    public void deletarFornecedor(int idFornecedor) throws SQLException {
        String sql = "DELETE FROM fornecedores WHERE id_fornecedor = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFornecedor);
            stmt.executeUpdate();
            System.out.println("Fornecedor deletado com sucesso.");
        }
    }
}
