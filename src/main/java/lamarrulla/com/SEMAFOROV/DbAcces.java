package lamarrulla.com.SEMAFOROV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAcces {
	static String server = "127.0.0.1";
	static String puerto = "5432";
	static String database = "SEMAFOROV";
	static String user = "postgres";
	static String passw = "maradr";
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	boolean closeRs;
	boolean closePs;
	boolean closeConnection;
	
	String strQuery;	
	
	public String getStrQuery() {
		return strQuery;
	}
	public void setStrQuery(String strQuery) {
		this.strQuery = strQuery;
	}
	public void connectDatabase() {
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try { 
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }            
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
	public void disconnectDatabase() {				
		try {
			if(rs!=null) {
				rs.close();
				closeRs = rs.isClosed();				
			}
			if(ps!=null) {
				ps.close();
				closePs = ps.isClosed();
			}
			if(connection!=null) {
				connection.close();
				closeConnection = connection.isClosed();
			}
							
			System.out.println(closeConnection||closeRs||closePs?"Coneccion cerrada":"valida la conexion sigue abierta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Existio un error al cerrar la conexion");
		}		
	}
	public void Insert() {
		try {
			ps = connection.prepareStatement(strQuery);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error al ejecutar insert: " + e.getMessage());
		}					
	}
}