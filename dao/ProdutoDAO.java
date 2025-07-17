package dao;

import java.sql.*;

public class ProdutoDAO {
    private Connection conn;

    public ProdutoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserirProduto(String nome, double preco) throws SQLException {
        String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.executeUpdate();
            System.out.println("Produto inserido com sucesso.");
        }
    }

    public void listarProdutos() throws SQLException {
        String sql = "SELECT * FROM produtos";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | Nome: %s | Preço: %.2f | Estoque: %d\n",
                        rs.getInt("id_produto"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade_em_estoque"));
            }
        }
    }

    public void atualizarProduto(int idProduto, String novoNome, double novoPreco) throws SQLException {
        String sql = "UPDATE produtos SET nome = ?, preco = ? WHERE id_produto = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoNome);
            stmt.setDouble(2, novoPreco);
            stmt.setInt(3, idProduto);
            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso.");
        }
    }

    public void deletarProduto(int idProduto) throws SQLException {
        String sql = "DELETE FROM produtos WHERE id_produto = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
            System.out.println("Produto deletado com sucesso.");
        }
    }
}
