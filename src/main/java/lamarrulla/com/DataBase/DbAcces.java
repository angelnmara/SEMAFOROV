package lamarrulla.com.DataBase;

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
	static int tipoDatabase = 2;
	private String instance = "deep-clock-253820:us-central1:semafirivi";
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	boolean closeRs;
	boolean closePs;
	boolean closeConnection;
	
	String strQuery;
	int idReturned;
	
	public int getIdReturned() {
		return idReturned;
	}
	public void setIdReturned(int idReturned) {
		this.idReturned = idReturned;
	}
	public String getStrQuery() {
		return strQuery;
	}
	public void setStrQuery(String strQuery) {
		this.strQuery = strQuery;
	}
	
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
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
            
            switch(tipoDatabase) {
            	case 1:
            		// Conectamos con la base de datos
            		connection = DriverManager.getConnection(
                            "jdbc:postgresql://" + server + ":" + puerto + "/" + database,
                            user, passw);
            		break;
            	case 2:
            		// conectamos con gcloud            
            		String jdbcUrl = String.format(
            			    "jdbc:postgresql://google/%s?socketFactory=com.google.cloud.sql.postgres.SocketFactory"
            			        + "&cloudSqlInstance=%s",
            			    database,
            			    instance);
            		connection = DriverManager.getConnection(jdbcUrl, user, passw);

                    break;
                default:
                	System.out.println("No se ha definido una conexion a base de datos");
                	break;                	            	
            }                                                         

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
							
			//System.out.println(closeConnection||closeRs||closePs?"Coneccion cerrada":"valida la conexion sigue abierta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Existio un error al cerrar la conexion");
		}		
	}
	public void execQry() {
		try {
			ps = connection.prepareStatement(strQuery);
			ps.execute();
			rs = ps.getResultSet();
			if(rs!=null) {
				if(rs.next()) {
					idReturned = rs.getInt(1);
				}	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error al ejecutar insert: " + e.getMessage());
		}					
	}	
}