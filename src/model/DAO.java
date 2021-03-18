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
			System.out.println("Conhexão realizada com sucesso!!");
		
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

	//Parâmetros da conexão
    private String driver = "org.postgresql.Driver";
    private String url ="jdbc:postgresql://localhost:5432/agendadb";
    private String user = "postgres";
	private String password = "pailer123";
	//Conexão com o banco de dados
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
//			System.out.println("Conexão realizada com sucesso!");
//			con.close();	
//		} catch (Exception e) {
//			System.out.println(e); 
//			System.out.println("Conexão Falhou!");
//		}
//	}

}
