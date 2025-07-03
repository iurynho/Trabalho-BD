# Sistema de Gestão Empresarial

## Descrição do Projeto

Este projeto é um sistema básico para gestão empresarial que inclui o controle de:

- Usuários
- Funcionários
- Produtos
- Fornecedores
- Clientes
- Vendas
- Compras

O backend é desenvolvido em Java, utilizando DAOs para realizar operações CRUD no banco de dados MySQL.

Além das operações básicas, o sistema possui consultas SQL para gerar relatórios gerenciais importantes.

---

## Configuração do Banco de Dados

### 1. Criação das tabelas

Execute o script SQL `create_tables.sql` para criar todas as tabelas do banco:

- `usuarios`
- `funcionarios`
- `produtos`
- `fornecedores`
- `clientes`
- `vendas`
- `itens_venda`
- `compras`
- `itens_compra`

### 2. Inserção de dados

Execute o script `insert_data.sql` para popular as tabelas com dados iniciais de exemplo.

---

## DAOs Java

No pacote `dao`, existem classes que implementam o padrão DAO para manipular os dados das tabelas.

### Classes principais

- `UsuarioDAO`: CRUD para a tabela `usuarios`
- `FuncionarioDAO`: CRUD para a tabela `funcionarios`
- (Outros DAOs podem ser criados seguindo o mesmo padrão para as demais tabelas)

### Exemplos de uso

```java
// Criar conexão
Connection conn = DriverManager.getConnection(dbUrl, user, password);

// Instanciar DAO
FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conn);

// Inserir funcionário
funcionarioDAO.inserirFuncionario("João Silva", "12345678900", "Analista", Date.valueOf("2023-01-15"), Date.valueOf("2023-01-20"));

// Listar funcionários
List<String> lista = funcionarioDAO.listarFuncionarios();
lista.forEach(System.out::println);

// Atualizar cargo
funcionarioDAO.atualizarCargo(1, "Gerente");

// Deletar funcionário
funcionarioDAO.deletarFuncionario(1);
