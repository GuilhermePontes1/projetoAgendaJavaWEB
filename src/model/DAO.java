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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	// Parâmetros da conexão
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/agendadb";
	private String user = "postgres";
	private String password = "123";

	// Conexão com o banco de dados
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
			// abrir a conexão com o banco de dados
			Connection con = conectar();
			// Preparar a Query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substitui os parâmetros (???) pelo conteudo das variáveis do JavaBeans
			pst.setString(1, agenda.getNome());
			pst.setString(2, agenda.getFone());
			pst.setString(3, agenda.getEmail());
			// Executa a Querry ou seja insere os dados no banco
			pst.executeUpdate();
			// Encerrar a conexão com o banco de dados
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	/* CRUD READ */
	public ArrayList<JavaBeans> listarAgenda() {
		// Criando objeto para acessar o JavaBeans.
		ArrayList<JavaBeans> agenda = new ArrayList<>();

		String read = "select  * from  agenda order by nome";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laço de repetição ficará sendo executado enquanto houver contatos.
			while (rs.next()) {
				// Variaveis de apoi que recebem os dados do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// populando o ArrayList
				agenda.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return agenda;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// public void testeConexao ( ) {
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
