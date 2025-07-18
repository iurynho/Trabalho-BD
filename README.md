

# Sistema de Gestão Empresarial

## Descrição do Projeto

Este projeto é um sistema básico para gestão empresarial que inclui o controle de:

* Usuários
* Funcionários
* Produtos
* Fornecedores
* Clientes
* Vendas
* Compras

O backend é desenvolvido em Java, utilizando DAOs para realizar operações CRUD no banco de dados MySQL.

Além das operações básicas, o sistema possui consultas SQL para gerar relatórios gerenciais importantes.

---

## Configuração do Banco de Dados

### 1. Criação das tabelas

Execute o script SQL `create_tables.sql` para criar todas as tabelas do banco:

* `usuarios`
* `funcionarios`
* `produtos`
* `fornecedores`
* `clientes`
* `vendas`
* `itens_venda`
* `compras`
* `itens_compra`

### 2. Inserção de dados

Execute o script `insert_data.sql` para popular as tabelas com dados iniciais de exemplo.

---

## DAOs Java

No pacote `dao`, existem classes que implementam o padrão DAO para manipular os dados das tabelas.

### Classes principais

* `UsuarioDAO`: CRUD para a tabela `usuarios`
* `FuncionarioDAO`: CRUD para a tabela `funcionarios`
* `ProdutoDAO`: CRUD para a tabela `produtos`
* `FornecedorDAO`: CRUD para a tabela `fornecedores`
* `VendaDAO`: Gerenciamento de vendas e itens de venda, incluindo atualização do estoque
* `CompraDAO`: Gerenciamento de compras e itens de compra
* `FeriasDAO`: Controle de férias dos funcionários
* `RelatorioDAO`: Consultas complexas e relatórios

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
```

---

## Como Compilar e Executar

### Pré-requisitos

* Java JDK 8 ou superior instalado
* MySQL instalado e rodando
* Configurar as credenciais do banco de dados no arquivo `ConexaoBanco.java`

### Passos para compilar

1. Compile as classes Java (assumindo que você está na pasta `src`):

```bash
javac -d ../bin dao/*.java Main.java
```

2. Execute o programa (estando na pasta `bin`):

```bash
java Main
```

### Configuração da conexão

No arquivo `ConexaoBanco.java`, configure:

```java
private static final String URL = "jdbc:mysql://localhost:3306/sistema_empresa";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
```

---

## Estrutura do Projeto

```
/src
  /dao
    UsuarioDAO.java
    FuncionarioDAO.java
    ProdutoDAO.java
    FornecedorDAO.java
    VendaDAO.java
    CompraDAO.java
    FeriasDAO.java
    RelatorioDAO.java
  ConexaoBanco.java
  Main.java
/scripts
  create_tables.sql
  insert_data.sql
```

---

## Observações Finais

* O sistema possui tratamento básico de erros e validação das entradas pelo console.
* As transações são usadas para operações que modificam várias tabelas (como vendas).
* Os menus são organizados por módulos para facilitar a navegação.

---

