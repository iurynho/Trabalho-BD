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
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("\n=== GERENCIAR USUÁRIOS ===");
                        System.out.println("1. Inserir Usuário");
                        System.out.println("2. Listar Usuários");
                        System.out.println("3. Atualizar Usuário");
                        System.out.println("4. Deletar Usuário");
                        System.out.print("Escolha uma opção: ");
                        int opcaoUsuario = scanner.nextInt();

                        if (opcaoUsuario == 1) {
                            scanner.nextLine(); // limpar buffer
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Email: ");
                            String email = scanner.nextLine();
                            System.out.print("Senha: ");
                            String senha = scanner.nextLine();
                            usuarioDAO.inserirUsuario(nome, email, senha, new Date(System.currentTimeMillis()));
                        } else if (opcaoUsuario == 2) {
                            usuarioDAO.listarUsuarios().forEach(System.out::println);
                        } else if (opcaoUsuario == 3) {
                            System.out.print("ID do Usuário: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Novo Email: ");
                            String novoEmail = scanner.nextLine();
                            usuarioDAO.atualizarUsuario(id, novoEmail);
                        } else if (opcaoUsuario == 4) {
                            System.out.print("ID do Usuário: ");
                            int id = scanner.nextInt();
                            usuarioDAO.deletarUsuario(id);
                        } else {
                            System.out.println("Opção inválida!");
                        }
                        break;

                    case 2:
                        System.out.println("\n=== GERENCIAR FUNCIONÁRIOS ===");
                        System.out.println("1. Inserir Funcionário");
                        System.out.println("2. Listar Funcionários");
                        System.out.println("3. Atualizar Cargo");
                        System.out.println("4. Deletar Funcionário");
                        System.out.print("Escolha uma opção: ");
                        int opcaoFuncionario = scanner.nextInt();

                        if (opcaoFuncionario == 1) {
                            scanner.nextLine();
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("CPF: ");
                            String cpf = scanner.nextLine();
                            System.out.print("Cargo: ");
                            String cargo = scanner.nextLine();
                            funcionarioDAO.inserirFuncionario(nome, cpf, cargo, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
                        } else if (opcaoFuncionario == 2) {
                            funcionarioDAO.listarFuncionarios().forEach(System.out::println);
                        } else if (opcaoFuncionario == 3) {
                            System.out.print("ID do Funcionário: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Novo Cargo: ");
                            String novoCargo = scanner.nextLine();
                            funcionarioDAO.atualizarCargo(id, novoCargo);
                        } else if (opcaoFuncionario == 4) {
                            System.out.print("ID do Funcionário: ");
                            int id = scanner.nextInt();
                            funcionarioDAO.deletarFuncionario(id);
                        } else {
                            System.out.println("Opção inválida!");
                        }
                        break;

                    case 3:
                        System.out.println("\n=== RELATÓRIOS DISPONÍVEIS ===");
                        System.out.println("1. Vendas com Clientes e Produtos (JOIN)");
                        System.out.println("2. Relatório com Group By");
                        System.out.println("3. Relatório com Funções de Data");
                        System.out.println("4. Consulta Aninhada");
                        System.out.print("Escolha uma opção: ");
                        int opcaoRelatorio = scanner.nextInt();

                        switch (opcaoRelatorio) {
                            case 1:
                                relatorioDAO.listarVendasComClienteEProduto();
                                break;
                            case 2:
                                relatorioDAO.relatorioGroupBy();
                                break;
                            case 3:
                                relatorioDAO.relatorioFuncoesData();
                                break;
                            case 4:
                                relatorioDAO.relatorioConsultaAninhada();
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
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
