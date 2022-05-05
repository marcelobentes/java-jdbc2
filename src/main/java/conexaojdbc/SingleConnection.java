package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/posjava";
	private static String passawd = "mclmaia";
	private static String user = "postgres";
	private static Connection connection = null;
	
	//static para ser acesso de qualquer lugar
	static {
		conectar();
	}
	
	//contrutor
	public SingleConnection() {
		conectar();
	}



	private static void conectar() {
		try {
			
			if (connection == null) {
				Class.forName("org.postgresql.Driver");//forName Postgresql
				connection = DriverManager.getConnection(url, user, passawd);
				connection.setAutoCommit(false);
				System.out.println("Conectado com sucesso.");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static Connection getConnection () {
		
		return connection;
	}

}
