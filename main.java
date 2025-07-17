import dao.*;
import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = ConexaoBanco.conectar()) {
            Scanner scanner = new Scanner(System.in);

            UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conn);
            RelatorioDAO relatorioDAO = new RelatorioDAO(conn);

            while (true) {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Gerenciar Usuários");
                System.out.println("2. Gerenciar Funcionários");
                System.out.println("3. Gerar Relatórios");
                System.out.println("4. Gerenciar Vendas");
                System.out.println("5. Gerenciar Férias");
                System.out.println("6. Gerenciar Compras");
                System.out.println("7. Gerenciar Fornecedores");
                System.out.println("8. Gerenciar Produtos");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("\n=== GERENCIAR USUARIOS ===");
                        System.out.println("1. Inserir Usuário");
                        System.out.println("2. Listar Usuários");
                        System.out.println("3. Atualizar Email");
                        System.out.println("4. Deletar Usuário");
                        System.out.print("Escolha uma opção: ");
                        int opcaoUsuario = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoUsuario) {
                            case 1:
                                System.out.print("Nome: ");
                                String nomeUsuario = scanner.nextLine();
                                System.out.print("Email: ");
                                String emailUsuario = scanner.nextLine();
                                System.out.print("Senha: ");
                                String senhaUsuario = scanner.nextLine();
                                usuarioDAO.inserirUsuario(nomeUsuario, emailUsuario, senhaUsuario,
                                        new Date(System.currentTimeMillis()));
                                break;
                            case 2:
                                usuarioDAO.listarUsuarios().forEach(System.out::println);
                                break;
                            case 3:
                                System.out.print("ID do Usuário: ");
                                int idUsuarioAtualizar = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Novo Email: ");
                                String novoEmail = scanner.nextLine();
                                usuarioDAO.atualizarUsuario(idUsuarioAtualizar, novoEmail);
                                break;
                            case 4:
                                System.out.print("ID do Usuário: ");
                                int idUsuarioDeletar = scanner.nextInt();
                                usuarioDAO.deletarUsuario(idUsuarioDeletar);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;

                    case 2:
                        System.out.println("\n=== GERENCIAR FUNCIONaRIOS ===");
                        System.out.println("1. Inserir Funcionário");
                        System.out.println("2. Listar Funcionários");
                        System.out.println("3. Atualizar Cargo");
                        System.out.println("4. Deletar Funcionário");
                        System.out.print("Escolha uma opção: ");
                        int opcaoFuncionario = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoFuncionario) {
                            case 1:
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                System.out.print("CPF: ");
                                String cpf = scanner.nextLine();
                                System.out.print("Cargo: ");
                                String cargo = scanner.nextLine();
                                funcionarioDAO.inserirFuncionario(nome, cpf, cargo,
                                        new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
                                break;
                            case 2:
                                funcionarioDAO.listarFuncionarios().forEach(System.out::println);
                                break;
                            case 3:
                                System.out.print("ID do Funcionário: ");
                                int idFunc = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Novo Cargo: ");
                                String novoCargo = scanner.nextLine();
                                funcionarioDAO.atualizarCargo(idFunc, novoCargo);
                                break;
                            case 4:
                                System.out.print("ID do Funcionário: ");
                                int idExcluir = scanner.nextInt();
                                funcionarioDAO.deletarFuncionario(idExcluir);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;

                    case 3: {
                        System.out.println("\n=== RELATORIOS DISPONIVEIS ===");
                        System.out.println("1. Vendas com Clientes e Produtos (JOIN)");
                        System.out.println("2. Funcionários com cargo e datas");
                        System.out.println("3. Compras com informações do Fornecedor");
                        System.out.println("4. Quantidade de produtos vendidos por produto (GROUP BY)");
                        System.out.println("5. Total de vendas por cliente");
                        System.out.println("6. Média de preço dos produtos vendidos");
                        System.out.println("7. Vendas realizadas nos últimos 30 dias (funções de data)");
                        System.out.println("8. Quantidade de vendas por mês");
                        System.out.println("9. Produtos cadastrados no último mês");
                        System.out.println("10. Clientes com mais de 5 compras (consulta aninhada)");
                        System.out.println("11. Produtos com vendas acima da média (consulta aninhada)");
                        System.out.println(
                                "12. Clientes que não fizeram compras nos últimos 6 meses (consulta aninhada)");
                        System.out.print("Escolha uma opção: ");
                        int opcaoRelatorio = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoRelatorio) {
                            case 1:
                                relatorioDAO.listarVendasComClienteEProduto();
                                break;
                            case 2:
                                relatorioDAO.listarFuncionariosComCargoEData();
                                break;
                            case 3:
                                relatorioDAO.listarComprasComFornecedor();
                                break;
                            case 4:
                                relatorioDAO.relatorioGroupBy();
                                break;
                            case 5:
                                relatorioDAO.totalVendasPorCliente();
                                break;
                            case 6:
                                relatorioDAO.mediaPrecoProduto();
                                break;
                            case 7:
                                relatorioDAO.relatorioFuncoesData();
                                break;
                            case 8:
                                relatorioDAO.relatorioVendasPorMes();
                                break;
                            case 9:
                                relatorioDAO.relatorioProdutosRecentes();
                                break;
                            case 10:
                                relatorioDAO.relatorioConsultaAninhada();
                                break;
                            case 11:
                                relatorioDAO.relatorioProdutosMaisVendidos();
                                break;
                            case 12:
                                relatorioDAO.relatorioClientesSemCompraRecente();
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;
                    }

                    case 4:
                        VendaDAO vendaDAO = new VendaDAO(conn);
                        System.out.println("\n=== GERENCIAR VENDAS ===");
                        System.out.println("1. Inserir Venda");
                        System.out.println("2. Listar Vendas");
                        System.out.print("Escolha uma opção: ");
                        int opcaoVenda = scanner.nextInt();
                        scanner.nextLine();

                        if (opcaoVenda == 1) {
                            System.out.print("ID do Usuário (vendedor): ");
                            int idUsuario = scanner.nextInt();
                            System.out.print("ID do Cliente: ");
                            int idCliente = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Data da Venda (YYYY-MM-DD): ");
                            String dataVendaStr = scanner.nextLine();
                            Date dataVenda = Date.valueOf(dataVendaStr);
                            System.out.print("ID do Produto: ");
                            int idProduto = scanner.nextInt();
                            System.out.print("Quantidade do Produto: ");
                            int quantidade = scanner.nextInt();
                            System.out.print("Preço Unitário do Produto: ");
                            double precoUnitario = scanner.nextDouble();

                            boolean sucesso = vendaDAO.inserirVenda(idUsuario, idCliente, dataVenda, idProduto,
                                    quantidade, precoUnitario);
                            System.out.println(sucesso ? "Venda inserida com sucesso!" : "Falha ao inserir venda.");
                        } else if (opcaoVenda == 2) {
                            // Código para listar vendas (pode chamar métodos do VendaDAO)
                            // Pode implementar depois
                        } else {
                            System.out.println("Opção inválida!");
                        }
                        break;

                    case 5:
                        FeriasDAO feriasDAO = new FeriasDAO(conn);
                        System.out.println("\n=== GERENCIAR FÉRIAS ===");
                        System.out.println("1. Inserir Férias");
                        System.out.println("2. Listar Férias");
                        System.out.println("3. Atualizar Férias");
                        System.out.println("4. Deletar Férias");
                        System.out.print("Escolha uma opção: ");
                        int opcaoFerias = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoFerias) {
                            case 1:
                                System.out.print("ID do Funcionário: ");
                                int idFunc = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Data Início (YYYY-MM-DD): ");
                                Date dataInicio = Date.valueOf(scanner.nextLine());
                                System.out.print("Data Fim (YYYY-MM-DD): ");
                                Date dataFim = Date.valueOf(scanner.nextLine());
                                feriasDAO.inserirFerias(idFunc, dataInicio, dataFim);
                                break;
                            case 2:
                                feriasDAO.listarFerias();
                                break;
                            case 3:
                                System.out.print("ID das Férias: ");
                                int idFeriasAtualizar = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nova Data Início (YYYY-MM-DD): ");
                                Date novaInicio = Date.valueOf(scanner.nextLine());
                                System.out.print("Nova Data Fim (YYYY-MM-DD): ");
                                Date novaFim = Date.valueOf(scanner.nextLine());
                                feriasDAO.atualizarFerias(idFeriasAtualizar, novaInicio, novaFim);
                                break;
                            case 4:
                                System.out.print("ID das Férias: ");
                                int idFeriasDeletar = scanner.nextInt();
                                feriasDAO.deletarFerias(idFeriasDeletar);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;

                    case 6:
                        CompraDAO compraDAO = new CompraDAO(conn);
                        System.out.println("\n=== GERENCIAR COMPRAS ===");
                        System.out.println("1. Inserir Compra");
                        System.out.println("2. Listar Compras");
                        System.out.println("3. Atualizar Compra");
                        System.out.println("4. Deletar Compra");
                        System.out.print("Escolha uma opção: ");
                        int opcaoCompra = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoCompra) {
                            case 1:
                                System.out.print("ID do Fornecedor: ");
                                int idFornecedorCompra = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Data da Compra (YYYY-MM-DD): ");
                                Date dataCompra = Date.valueOf(scanner.nextLine());
                                scanner.nextLine();
                                compraDAO.inserirCompra(idFornecedorCompra, dataCompra);
                                break;
                            case 2:
                                compraDAO.listarCompras();
                                break;
                            case 3:
                                System.out.print("ID da Compra: ");
                                int idCompraAtualizar = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("ID do Novo Fornecedor: ");
                                int idNovoFornecedor = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nova Data (YYYY-MM-DD): ");
                                Date novaDataCompra = Date.valueOf(scanner.nextLine());

                                scanner.nextLine();
                                compraDAO.atualizarCompra(idCompraAtualizar, idNovoFornecedor, novaDataCompra);
                                break;
                            case 4:
                                System.out.print("ID da Compra a deletar: ");
                                int idCompraDeletar = scanner.nextInt();
                                compraDAO.deletarCompra(idCompraDeletar);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;

                    case 7:
                        FornecedorDAO fornecedorDAO = new FornecedorDAO(conn);
                        System.out.println("\n=== GERENCIAR FORNECEDORES ===");
                        System.out.println("1. Inserir Fornecedor");
                        System.out.println("2. Listar Fornecedores");
                        System.out.println("3. Atualizar Fornecedor");
                        System.out.println("4. Deletar Fornecedor");
                        System.out.print("Escolha uma opção: ");
                        int opcaoFornecedor = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoFornecedor) {
                            case 1:
                                System.out.print("Nome: ");
                                String nomeFornecedor = scanner.nextLine();
                                System.out.print("CNPJ: ");
                                String cnpj = scanner.nextLine();
                                fornecedorDAO.inserirFornecedor(nomeFornecedor, cnpj);
                                break;
                            case 2:
                                fornecedorDAO.listarFornecedores();
                                break;
                            case 3:
                                System.out.print("ID do Fornecedor: ");
                                int idFornecedorAtualizar = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Novo Nome: ");
                                String novoNomeFornecedor = scanner.nextLine();
                                fornecedorDAO.atualizarFornecedor(idFornecedorAtualizar, novoNomeFornecedor);
                                break;
                            case 4:
                                System.out.print("ID do Fornecedor: ");
                                int idFornecedorDeletar = scanner.nextInt();
                                fornecedorDAO.deletarFornecedor(idFornecedorDeletar);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;

                    case 8:
                        ProdutoDAO produtoDAO = new ProdutoDAO(conn);
                        System.out.println("\n=== GERENCIAR PRODUTOS ===");
                        System.out.println("1. Inserir Produto");
                        System.out.println("2. Listar Produtos");
                        System.out.println("3. Atualizar Produto");
                        System.out.println("4. Deletar Produto");
                        System.out.print("Escolha uma opção: ");
                        int opcaoProduto = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoProduto) {
                            case 1:
                                System.out.print("Nome: ");
                                String nomeProduto = scanner.nextLine();
                                System.out.print("Preço: ");
                                double preco = scanner.nextDouble();
                                scanner.nextLine();
                                produtoDAO.inserirProduto(nomeProduto, preco);
                                break;
                            case 2:
                                produtoDAO.listarProdutos();
                                break;
                            case 3:
                                System.out.print("ID do Produto: ");
                                int idProdutoAtualizar = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Novo Nome: ");
                                String novoNome = scanner.nextLine();
                                System.out.print("Novo Preço: ");
                                double novoPreco = scanner.nextDouble();
                                scanner.nextLine();
                                produtoDAO.atualizarProduto(idProdutoAtualizar, novoNome, novoPreco);
                                break;
                            case 4:
                                System.out.print("ID do Produto: ");
                                int idProdutoDeletar = scanner.nextInt();
                                produtoDAO.deletarProduto(idProdutoDeletar);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opção inválida!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
