package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelatorioDAO {
    private Connection conn;

    public RelatorioDAO(Connection conn) {
        this.conn = conn;
    }

    // 3 consultas com JOIN

    public void listarVendasComClienteEProduto() {
        System.out.println("\nRelatório: Vendas com informações do Cliente e Produto (JOIN)");
        String sql = "SELECT v.id_venda, c.nome AS cliente_nome, p.nome AS produto_nome, iv.quantidade, iv.preco_unitario " +
                     "FROM vendas v " +
                     "JOIN clientes c ON v.id_cliente = c.id_cliente " +
                     "JOIN itens_venda iv ON v.id_venda = iv.id_venda " +
                     "JOIN produtos p ON iv.id_produto = p.id_produto";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Venda %d: Cliente: %s, Produto: %s, Quantidade: %d, Preço Unitário: %.2f\n",
                        rs.getInt("id_venda"),
                        rs.getString("cliente_nome"),
                        rs.getString("produto_nome"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco_unitario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarFuncionariosComCargoEData() {
        System.out.println("\nRelatório: Funcionários com cargo e datas");
        String sql = "SELECT nome, cargo, data_admissao, data_inicio_trabalho FROM funcionarios";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Nome: %s, Cargo: %s, Data Admissão: %s, Data Início Trabalho: %s\n",
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getDate("data_admissao"),
                        rs.getDate("data_inicio_trabalho"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarComprasComFornecedor() {
        System.out.println("\nRelatório: Compras com informações do Fornecedor");
        String sql = "SELECT c.id_compra, f.nome AS fornecedor_nome, c.data_compra " +
                     "FROM compras c " +
                     "JOIN fornecedores f ON c.id_fornecedor = f.id_fornecedor";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Compra %d: Fornecedor: %s, Data Compra: %s\n",
                        rs.getInt("id_compra"),
                        rs.getString("fornecedor_nome"),
                        rs.getDate("data_compra"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3 consultas com GROUP BY e HAVING / funções agregadas

    public void relatorioGroupBy() {
        System.out.println("\nRelatório: Quantidade de produtos vendidos por produto");
        String sql = "SELECT p.nome, SUM(iv.quantidade) AS total_vendido " +
                     "FROM produtos p " +
                     "JOIN itens_venda iv ON p.id_produto = iv.id_produto " +
                     "GROUP BY p.nome " +
                     "HAVING SUM(iv.quantidade) > 10";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Produto: %s, Total Vendido: %d\n",
                        rs.getString("nome"),
                        rs.getInt("total_vendido"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void totalVendasPorCliente() {
        System.out.println("\nRelatório: Total de vendas por cliente");
        String sql = "SELECT c.nome, COUNT(v.id_venda) AS total_vendas " +
                     "FROM clientes c " +
                     "JOIN vendas v ON c.id_cliente = v.id_cliente " +
                     "GROUP BY c.nome";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Cliente: %s, Total Vendas: %d\n",
                        rs.getString("nome"),
                        rs.getInt("total_vendas"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mediaPrecoProduto() {
        System.out.println("\nRelatório: Média de preço dos produtos vendidos");
        String sql = "SELECT p.nome, AVG(iv.preco_unitario) AS preco_medio " +
                     "FROM produtos p " +
                     "JOIN itens_venda iv ON p.id_produto = iv.id_produto " +
                     "GROUP BY p.nome";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Produto: %s, Preço Médio: %.2f\n",
                        rs.getString("nome"),
                        rs.getDouble("preco_medio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3 consultas com funções de data

    public void relatorioFuncoesData() {
        System.out.println("\nRelatório: Vendas realizadas nos últimos 30 dias");
        String sql = "SELECT id_venda, data_venda FROM vendas WHERE data_venda >= CURRENT_DATE - INTERVAL '30 days'";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Venda ID: %d, Data Venda: %s\n",
                        rs.getInt("id_venda"),
                        rs.getDate("data_venda"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void relatorioVendasPorMes() {
        System.out.println("\nRelatório: Quantidade de vendas por mês");
        String sql = "SELECT EXTRACT(MONTH FROM data_venda) AS mes, COUNT(*) AS total_vendas " +
                     "FROM vendas GROUP BY mes ORDER BY mes";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Mês: %d, Total Vendas: %d\n",
                        rs.getInt("mes"),
                        rs.getInt("total_vendas"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void relatorioProdutosRecentes() {
        System.out.println("\nRelatório: Produtos cadastrados no último mês");
        String sql = "SELECT nome, data_cadastro FROM produtos WHERE data_cadastro >= CURRENT_DATE - INTERVAL '30 days'";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Produto: %s, Data Cadastro: %s\n",
                        rs.getString("nome"),
                        rs.getDate("data_cadastro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3 consultas aninhadas

    public void relatorioConsultaAninhada() {
        System.out.println("\nRelatório: Clientes com mais de 5 compras");

        String sql = "SELECT nome FROM clientes WHERE id_cliente IN (" +
                     "SELECT id_cliente FROM vendas GROUP BY id_cliente HAVING COUNT(*) > 5" +
                     ")";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Cliente: %s\n", rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void relatorioProdutosMaisVendidos() {
        System.out.println("\nRelatório: Produtos com vendas acima da média");

        String sql = "SELECT nome FROM produtos WHERE id_produto IN (" +
                     "SELECT id_produto FROM itens_venda GROUP BY id_produto HAVING SUM(quantidade) > (" +
                     "SELECT AVG(total) FROM (" +
                     "SELECT SUM(quantidade) AS total FROM itens_venda GROUP BY id_produto" +
                     ") AS subquery))";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Produto: %s\n", rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void relatorioClientesSemCompraRecente() {
        System.out.println("\nRelatório: Clientes que não fizeram compras nos últimos 6 meses");

        String sql = "SELECT nome FROM clientes WHERE id_cliente NOT IN (" +
                     "SELECT DISTINCT id_cliente FROM vendas WHERE data_venda >= CURRENT_DATE - INTERVAL '6 months'" +
                     ")";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Cliente: %s\n", rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
