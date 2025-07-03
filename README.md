# Sistema de Gestão Empresarial - Banco de Dados

Este projeto define um banco de dados relacional completo para um sistema de gestão empresarial, contendo estruturas para controle de usuários, funcionários, férias, produtos, fornecedores, clientes, vendas e compras.

## 🛠 Estrutura do Banco de Dados

O banco de dados `sistema_empresa` é composto pelas seguintes tabelas:

- **usuarios**: Armazena os dados de acesso dos usuários do sistema.
- **funcionarios**: Contém informações pessoais e contratuais dos funcionários.
- **ferias**: Controla os períodos de férias dos funcionários.
- **produtos**: Contém os itens vendidos ou comprados pela empresa.
- **fornecedores**: Registra os fornecedores de produtos.
- **clientes**: Guarda os dados dos clientes que realizam compras.
- **vendas**: Armazena os registros de vendas realizadas.
- **itens_venda**: Detalha os produtos vendidos em cada venda.
- **compras**: Armazena os registros de compras feitas pela empresa.
- **itens_compra**: Detalha os produtos adquiridos em cada compra.

## ▶️ Como usar

1. **Requisitos**:  
   - Servidor MySQL ou MariaDB
   - Ferramenta cliente como MySQL Workbench, DBeaver ou terminal

2. **Execução**:  
   Basta importar o arquivo `script_completo_com_insercoes.sql` no seu SGBD. Ele criará o banco de dados, as tabelas e preencherá com dados de exemplo.

   ```sql
   SOURCE caminho/para/script_completo_com_insercoes.sql;
