package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb{
    private Connection connection;
    private final String jdbcURL = "jdbc:mysql://localhost:3306/nombredb";
    private final String username = "usr";
    private final String password = "pwd";
    public ConnectionDb(){
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión a la base de datos.");
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión.");
            e.printStackTrace();
        }
    }
}