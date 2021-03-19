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
import java.sql.PreparedStatement;

public class DAO {

	// Par�metros da conex�o
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/agendadb";
	private String user = "postgres";
	private String password = "123";

	// Conex�o com o banco de dados
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

		/* CRUD CREATE */

	}

	public void inserirContatoAgenda(JavaBeans agenda) {
		String create = "insert into agenda (nome,fone,email) values (?,?,?);";

		try {
			// abrir a conex�o com o banco de dados
			Connection con = conectar();
			// Preparar a Query para execu��o no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substitui os par�metros (???) pelo conteudo das vari�veis do JavaBeans
			pst.setString(1, agenda.getNome());
			pst.setString(2, agenda.getFone());
			pst.setString(3, agenda.getEmail());
			// Executa a Querry ou seja insere os dados no banco
			pst.executeUpdate();
			// Encerrar a conex�o com o banco de dados
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	// public void testeConexao ( ) {
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
