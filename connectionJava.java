public class ConexaoBanco {
    public static Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sistema_empresa";
        String usuario = "root";
        String senha = "SUA_SENHA";
        return DriverManager.getConnection(url, usuario, senha);
    }
}
