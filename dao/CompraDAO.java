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
    String sql = "SELECT c.id_compra, c.data_compra, f.nome AS nome_fornecedor, " +
                 "ic.id_produto, p.nome AS nome_produto, ic.quantidade, ic.preco_unitario " +
                 "FROM compras c " +
                 "JOIN fornecedores f ON c.id_fornecedor = f.id_fornecedor " +
                 "JOIN itens_compra ic ON c.id_compra = ic.id_compra " +
                 "JOIN produtos p ON ic.id_produto = p.id_produto " +
                 "ORDER BY c.id_compra";

    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        int compraAtual = -1;
        while (rs.next()) {
            int idCompra = rs.getInt("id_compra");

            if (idCompra != compraAtual) {
                compraAtual = idCompra;
                System.out.println("\n==============================");
                System.out.println("Compra ID: " + idCompra);
                System.out.println("Data: " + rs.getDate("data_compra"));
                System.out.println("Fornecedor: " + rs.getString("nome_fornecedor"));
                System.out.println("Itens:");
            }

            System.out.printf("  - Produto: %s (ID %d), Quantidade: %d, Preço Unit.: R$ %.2f\n",
                    rs.getString("nome_produto"),
                    rs.getInt("id_produto"),
                    rs.getInt("quantidade"),
                    rs.getDouble("preco_unitario"));
        }
    }
}


    public void atualizarCompra(int idCompra, int novoIdFornecedor, Date novaData) {
    String sql = "UPDATE compras SET id_fornecedor = ?, data_compra = ? WHERE id_compra = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, novoIdFornecedor);
        stmt.setDate(2, novaData);
        stmt.setInt(3, idCompra);

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected == 0) {
            System.out.println("Nenhuma compra encontrada com o ID informado.");
        } else {
            System.out.println("Compra atualizada com sucesso.");
        }

    } catch (SQLException e) {
        System.out.println("Erro ao atualizar a compra. Verifique se os IDs informados existem.");
        e.printStackTrace(); // Pode remover em produção
    }
}


    public void deletarCompra(int idCompra) {
    String sql = "DELETE FROM compras WHERE id_compra = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idCompra);

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected == 0) {
            System.out.println("Nenhuma compra encontrada com o ID informado.");
        } else {
            System.out.println("Compra deletada com sucesso.");
        }

    } catch (SQLException e) {
        System.out.println("Erro ao deletar a compra. Verifique se o ID informado é válido.");
        e.printStackTrace(); // Pode remover em produção
    }
}}
