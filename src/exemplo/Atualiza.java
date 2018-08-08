package exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Atualiza {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/dbclientes";
		String usuario = "postgres";
		String senha = "postgres";
		PreparedStatement statement;
		try {
			Connection connection = DriverManager.getConnection(url, usuario, senha);
			JOptionPane.showMessageDialog(null,	"Conexao realizada com sucesso!");
			String sql = "UPDATE clientes SET nome = ? WHERE codigo = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "Ana Paula"); // Alterei o nome Ana para Ana Paula
	                statement.setInt(2, 1); //c�digo 1 da tabela clientes ser� alterado
			statement.execute();
			connection.close();
			JOptionPane.showMessageDialog(null,	"Atualiza��o de cliente realizada com sucesso!");
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,	"Problemas na conexao com o banco de dados"	+ erro.toString());
		}
	}
}