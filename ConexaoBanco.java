import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    public static Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sistema_empresa";
        String usuario = "root";
        String senha = "Anglo102914.";
        return DriverManager.getConnection(url, usuario, senha);
    }
}
