package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeriasDAO {
    private Connection conn;

    public FeriasDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserirFerias(int idFuncionario, Date dataInicio, Date dataFim) throws SQLException {
    long diffMillis = dataFim.getTime() - dataInicio.getTime();
    long diffDias = diffMillis / (24 * 60 * 60 * 1000) + 1; // total de dias

    String sql = "INSERT INTO ferias (id_funcionario, data_inicio, data_fim, dias_ferias) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idFuncionario);
        stmt.setDate(2, dataInicio);
        stmt.setDate(3, dataFim);
        stmt.setLong(4, diffDias);
        stmt.executeUpdate();
        System.out.println("Férias inseridas com sucesso. Total de dias: " + diffDias);
    }
}


    public void listarFerias() throws SQLException {
        String sql = "SELECT * FROM ferias";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | Funcionário: %d | Início: %s | Fim: %s\n",
                        rs.getInt("id_ferias"),
                        rs.getInt("id_funcionario"),
                        rs.getDate("data_inicio"),
                        rs.getDate("data_fim"));
            }
        }
    }

    public void atualizarFerias(int idFerias, Date novaDataInicio, Date novaDataFim) throws SQLException {
        String sql = "UPDATE ferias SET data_inicio = ?, data_fim = ? WHERE id_ferias = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, novaDataInicio);
            stmt.setDate(2, novaDataFim);
            stmt.setInt(3, idFerias);
            stmt.executeUpdate();
            System.out.println("Férias atualizadas com sucesso.");
        }
    }

    public void deletarFerias(int idFerias) throws SQLException {
        String sql = "DELETE FROM ferias WHERE id_ferias = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFerias);
            stmt.executeUpdate();
            System.out.println("Férias deletadas com sucesso.");
        }
    }
}
