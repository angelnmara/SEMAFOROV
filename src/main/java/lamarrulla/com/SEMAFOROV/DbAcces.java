package lamarrulla.com.SEMAFOROV;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbAcces {
	static String server = "127.0.0.1";
	static String puerto = "5432";
	static String database = "SEMAFOROV";
	static String user = "postgres";
	static String passw = "maradr";
	Connection connection = null;
	
	public void connectDatabase() {
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try { 
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            Connection connection = null;
            // Database connect
            // Conectamos con la base de datos
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + server + ":" + puerto + "/" + database,
                    user, passw);

            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }
}
