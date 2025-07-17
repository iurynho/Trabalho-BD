package dao;

import java.sql.*;

public class CompraDAO {
    private Connection conn;

    public CompraDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserirCompra(int idFornecedor, Date dataCompra) throws SQLException {
        String sql = "INSERT INTO compras (id_fornecedor, data_compra) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFornecedor);
            stmt.setDate(2, dataCompra);
            stmt.executeUpdate();
            System.out.println("Compra inserida com sucesso.");
        }
    }

    public void listarCompras() throws SQLException {
        String sql = "SELECT * FROM compras";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | Fornecedor: %d | Data: %s\n",
                        rs.getInt("id_compra"),
                        rs.getInt("id_fornecedor"),
                        rs.getDate("data_compra"));
            }
        }
    }

    public void atualizarCompra(int idCompra, int novoIdFornecedor, Date novaData) throws SQLException {
        String sql = "UPDATE compras SET id_fornecedor = ?, data_compra = ? WHERE id_compra = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, novoIdFornecedor);
            stmt.setDate(2, novaData);
            stmt.setInt(3, idCompra);
            stmt.executeUpdate();
            System.out.println("Compra atualizada com sucesso.");
        }
    }

    public void deletarCompra(int idCompra) throws SQLException {
        String sql = "DELETE FROM compras WHERE id_compra = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCompra);
            stmt.executeUpdate();
            System.out.println("Compra deletada com sucesso.");
        }
    }
}
