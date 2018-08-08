package exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Consulta {
	public static void main(String[] args) {
		try {
			Conexao con = new Conexao();
			String sql = "SELECT * FROM clientes WHERE codigo = ?";
			statement = con.prepareStatement(sql);
			statement.setInt(1,1); // par�metro 1 indicando que � a coluna codigo, cujo conte�do � 1
			ResultSet result =  statement.executeQuery();
			System.out.println("COD     NOME");
			System.out.println("------  -------");
			if (result.next()) {
				Integer codigo = result.getInt("codigo");
				String nome = result.getString("nome");
				System.out.println(codigo  +  "\t"  +  nome); 
			}
			statement.execute();
			connection.close();
			JOptionPane.showMessageDialog(null,	"Consulta de cliente realizada com sucesso!");
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,	"Problemas na conexao com o banco de dados"	+ erro.toString());
		}
	}
}
