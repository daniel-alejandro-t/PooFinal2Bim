import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase es un ayudante para trabajar con conexiones a la base de datos SQLite.
 * Proporciona métodos para obtener una nueva conexión y cerrar una conexión existente.
 */
public class DBUtil {
    
    /**
     * La cadena de conexión JDBC para la base de datos SQLite.
     */
    private static final String SQLITE_CONN = "jdbc:sqlite:src/resources/db/movutpl.db";

    /**
     * Obtiene una nueva conexión a la base de datos SQLite.
     *
     * @return una nueva conexión a la base de datos.
     * @throws SQLException si hay un error al obtener la conexión.
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQLITE_CONN);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Cierra la conexión proporcionada a la base de datos.
     *
     * @param conn la conexión a la base de datos a cerrar.
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
