/* package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	private String url;
	private String usuario;
	private String senha;
	private Connection con; 
	
	DAO(){
		url ="jdbc:postgresql://localhost:5432/agendadb";
		usuario = "postgres";
		senha = "postgres";
				
		try {
			Class.forName("org.postgre.Driver");
			con = DriverManager.getConnection(url,usuario,senha);
			System.out.println("Conhex�o realizada com sucesso!!");
		
		} catch (Exception e) {
				e.printStackTrace();
		}
				
	}

	
		
	
	
}
*/ 
package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO{

	//Par�metros da conex�o
    private String driver = "org.postgresql.Driver";
    private String url ="jdbc:postgresql://localhost:5432/agendadb";
    private String user = "postgres";
	private String password = "pailer123";
	//Conex�o com o banco de dados
	private Connection conectar () {
		Connection con = null; 
		
		try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		
		
	}
	
//	public void testeConexao ( ) {
//		try {
//			Connection con = conectar();
//			System.out.println(con); 
//			System.out.println("Conex�o realizada com sucesso!");
//			con.close();	
//		} catch (Exception e) {
//			System.out.println(e); 
//			System.out.println("Conex�o Falhou!");
//		}
//	}

}
