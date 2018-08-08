package exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Insere {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/dbclientes";
		String usuario = "postgres";
		String senha = "postgres";
		PreparedStatement statement;
		try {
			Connection connection = DriverManager.getConnection(url, usuario, senha);
			JOptionPane.showMessageDialog(null,	"Conexao realizada com sucesso!");
			String sql = "INSERT INTO clientes" + "(codigo, nome) VALUES (?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 1);
			statement.setString(2, "Ana");
			statement.execute();
			connection.close();
			JOptionPane.showMessageDialog(null,	"Adi��o de cliente realizada com sucesso!");
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,	"Problemas na conexao com o banco de dados"	+ erro.toString());
		}
	}
}
