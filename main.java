import dao.*;
import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = ConexaoBanco.conectar()) {
            Scanner scanner = new Scanner(System.in);

            UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
            FuncionarioDAODAO = new FuncionarioDAO(conn);

            while (true) {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Gerenciar Usuários");
                System.out.println("2. Gerenciar Funcionários");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("\n=== GERENCIAR USUÁRIOS ===");
                        System.out.println("1. Inserir Usuário");
                        System.println("2. Listar Usuários");
                        System.out.println("3. Atualizar Usuário");
                        System.out.println("4. Deletar Usuário");
                        System.out.print("Escolha uma opção: ");
                        int opcaoUsuario = scanner.nextInt();

                        if (opcaoUsuario == 1) {
                            System.out.print("Nome: ");
                            String nome = scanner.next();
                            System.out.print("Email: ");
                            String email = scanner.next();
                            System.out.print("Senha: ");
                            String senha = scanner.next();
                            usuarioDAO.inserirUsuario(nome email, senha, new Date(System.currentTimeMillis()));
                        } else if (opcaoUsuario == 2) {
                            usuarioDAO.listarUsuarios().forEach(System.out::println);
                        } else if (opcaoUsuario == 3) {
                            System.out.print("ID do Usuário: ");
                            int id = scanner.nextInt();
                            System.out.print("Novo Email: ");
                            String novoEmail = scanner.next();
                            usuarioDAO.atualizar(id, novoEmail);
                        } else if (opcaoUsuario == 4) {
                            System.out.print("ID do Usuário: ");
                            int id = scanner.nextInt();
                            usuarioDAO.deletarUsuario(id);
                        }
                        break;

                    case 2:
                        System.out.println("\n=== GERENCIAR FUNCIONÁRIOS ===");
                        System.out.println("1. Inserir Funcionário");
                        System.out.println("2 Listar Funcionários");
                        System.out.println("3. Atualizar Cargo");
                        System.out.println("4. Deletar Funcionário");
                        System.out.print("Escolha uma opção: ");
                        int opcaoFuncionario = scanner.nextInt();

                        if (opcaoFuncionario == 1) {
                            System.out.print("Nome: ");
                            String nome = scanner.next();
                            System.out.print("CPF: ");
                            String cpf = scanner.next();
                            System.out.print("Cargo: ");
                            String cargo = scanner.next();
                            funcionarioDAO.inserirFuncionario(nome, cpf, cargo, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
                        } else if (opcaoFuncionario == 2) {
                            funcionarioDAO.listarFuncionarios().forEach(System.out::println);
                        } else if (opcaoFuncionario == 3) {
                            System.out.print("ID do Funcionário: ");
                            int id = scanner.nextInt();
                            System.out.print("Novo Cargo: ");
                            String novoCargo = scanner.next();
                            funcionarioDAO.atualizarCargo(id, novoCargo);
                        } else if (opcaoFuncionario == 4) {
                            System.out.print("ID do Funcionário: ");
                            int id = scanner.nextInt();
                            funcionarioDAO.deletarFuncionario(id);
                        }
                        break;

                    case 0:
                        System.out.println("Saindo...");
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

