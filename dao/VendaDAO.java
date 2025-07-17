package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaDAO {
    private Connection conn;

    public VendaDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para inserir venda + itens e atualizar estoque
    public boolean inserirVenda(int idUsuario, int idCliente, Date dataVenda,
                               int idProduto, int quantidade, double precoUnitario) {
        try {
            // Desliga o auto-commit para controlar a transação manualmente
            conn.setAutoCommit(false);

            // Inserir na tabela vendas e obter o id da venda inserida
            String sqlInsertVenda = "INSERT INTO vendas (id_usuario, id_cliente, data_venda) VALUES (?, ?, ?)";
            PreparedStatement stmtVenda = conn.prepareStatement(sqlInsertVenda, PreparedStatement.RETURN_GENERATED_KEYS);
            stmtVenda.setInt(1, idUsuario);
            stmtVenda.setInt(2, idCliente);
            stmtVenda.setDate(3, dataVenda);
            int affectedRows = stmtVenda.executeUpdate();

            if (affectedRows == 0) {
                conn.rollback();
                return false;
            }

            // Obter o id gerado da venda
            ResultSet generatedKeys = stmtVenda.getGeneratedKeys();
            int idVenda;
            if (generatedKeys.next()) {
                idVenda = generatedKeys.getInt(1);
            } else {
                conn.rollback();
                return false;
            }

            // Inserir o item da venda
            String sqlInsertItem = "INSERT INTO itens_venda (id_venda, id_produto, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtItem = conn.prepareStatement(sqlInsertItem);
            stmtItem.setInt(1, idVenda);
            stmtItem.setInt(2, idProduto);
            stmtItem.setInt(3, quantidade);
            stmtItem.setDouble(4, precoUnitario);
            int rowsItem = stmtItem.executeUpdate();

            if (rowsItem == 0) {
                conn.rollback();
                return false;
            }

            // Atualizar a quantidade do produto no estoque
            String sqlUpdateProduto = "UPDATE produtos SET quantidade_em_estoque = quantidade_em_estoque - ? WHERE id_produto = ? AND quantidade_em_estoque >= ?";
            PreparedStatement stmtUpdateProduto = conn.prepareStatement(sqlUpdateProduto);
            stmtUpdateProduto.setInt(1, quantidade);
            stmtUpdateProduto.setInt(2, idProduto);
            stmtUpdateProduto.setInt(3, quantidade);
            int rowsUpdated = stmtUpdateProduto.executeUpdate();

            if (rowsUpdated == 0) {
                // Estoque insuficiente ou produto inexistente
                System.out.println("Estoque insuficiente para o produto ID " + idProduto);
                conn.rollback();
                return false;
            }

            // Confirma a transação
            conn.commit();
            conn.setAutoCommit(true);
            return true;

        } catch (SQLException e) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        }
    }
}
