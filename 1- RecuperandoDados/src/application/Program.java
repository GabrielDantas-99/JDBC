package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
	
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// Criando conexão com o BD
			conn = DB.getConnection();
			// Instanciando um obj do tipo statemet
			st = conn.createStatement();
			// Executando uma consulta ao banco de dados gerando um ResultSet
			rs = st.executeQuery("select * from department");
			// Exibindo na tela os IDs e os Names
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
