package exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
	String stringDeConexao = "jdbc:postgresql://localhost:5432/dbclientes";
	String usuario = "postgres";
	String senha = "postgres";
	PreparedStatement statement;

	public void conectar() {
		try {
			Connection connection = DriverManager.getConnection(stringDeConexao, usuario, senha);
			JOptionPane.showMessageDialog(null, "Conexao realizada com sucesso!");
			connection.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Problemas na conexao com a fonte de dados" + erro.toString());
		}
	}
}
