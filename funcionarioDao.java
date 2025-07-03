package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    Connection conn;

    public FuncionarioDAO(Connection conn) {
        this.conn = conn;
    }

    // CREATE
    public void inserirFuncionario(String nome, String cpf, String cargo, Date dataAdmissao, Date dataInicioTrabalho) {
        String sql = "INSERT INTO funcionarios (nome, cpf, cargo, data_admissao, data_inicio_trabalho) VALUES (?, ?, ?, ?, ?)";
 try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, cargo);
            stmt.setDate(4, dataAdmissao);
            stmt.setDate(5, dataInicioTrabalho);
            stmt.executeUpdate();
            System.out.println("Funcionário inserido com sucesso!");
        } catch ( e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<String> listarFuncionarios() {
        List<String> funcionarios = new Array<>();
        String sql = "SELECT * FROM funcionarios";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                funcionarios.add("ID: " + rs.getInt("id_funcionario") +
                                 ", Nome: " + rs.getString("nome") +
                                 ", CPF: " + rs.getString("cpf") +
                                 ", Cargo: " + rs.getString("cargo") +
                                 ", Data Admissão: " + rs.getDate("data_admissao") +
                                 ",ício Trabalho: " + rs.getDate("data_inicio_trabalho"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    // UPDATE
    public void atualizarCargo(int id, String novoCargo) {
        String sql = "UPDATE funcionarios SET cargo = ? WHERE id_funcionario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoCargo);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Cargo atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletarFuncionario(int id) {
        String sql = "DELETE FROM funcionarios WHERE id_funcionario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,);
            stmt.executeUpdate();
            System.println("Funcionário deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
