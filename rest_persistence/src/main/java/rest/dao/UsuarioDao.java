package rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rest.model.Usuario;
import rest.util.DbUtil;

public class UsuarioDao {

	private static Connection conexao = DbUtil.getConnection();
	private static String nomeTabela = "usuario";

	public static List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM " + nomeTabela;
		try {
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				usuarios.add(new Usuario(rs.getInt("id"),rs.getString("nome"),rs.getString("sobrenome"),rs.getString("senha"), rs.getString("matricula")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public static Usuario autenticar(String matricula, String senha) {
		Usuario usuario = null;
		String sql = "SELECT * FROM " + nomeTabela + " WHERE matricula=? AND senha=?";

		try {						
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return new Usuario(rs.getInt("id"),rs.getString("nome"),rs.getString("sobrenome"),rs.getString("senha"), rs.getString("matricula"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	
	
	public static Usuario cadastrar(String nome, String sobrenome, String senha, String matricula) {
		String sql = "insert into "+nomeTabela+"(nome, sobrenome, matricula, senha) values (?, ?, ?, ?)";
		PreparedStatement statement;
		Usuario usuario= null;
		
		if(getUsuario(matricula)==null) {
			try {
		     		statement = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				 	statement.setString(1, nome);
					statement.setString(2, sobrenome);
					statement.setString(3, matricula);
					statement.setString(4, senha);
					statement.executeUpdate();
					ResultSet rs = statement.getGeneratedKeys();
					if (rs.next()) {
						return getUsuario(matricula);
						//System.out.println(rs.getInt("id"));
						//return new Usuario(rs.getInt("id"),rs.getString("nome"),rs.getString("sobrenome"),rs.getString("senha"), rs.getString("matricula"));
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}			
		return usuario;
	}
	
	public static void deletar(int id) {
		String sql = "DELETE FROM "+nomeTabela+" WHERE id=?";
		PreparedStatement statement;		
		try {
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	
	public static Usuario alterarSenha(int id, String senha) {
		String sql = "UPDATE "+nomeTabela+ " SET senha=? WHERE id=?";
		PreparedStatement statement;
		Usuario usuario = null;
		try {
			statement = conexao.prepareStatement(sql);
			statement.setString(1,senha);
			statement.setInt(2, id);
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				return new Usuario(rs.getInt("id"),rs.getString("nome"),rs.getString("sobrenome"),rs.getString("senha"), rs.getString("matricula"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	public static Usuario getUsuario(String matricula) {
		String sql ="SELECT id, nome, sobrenome, matricula, senha FROM "+nomeTabela+" WHERE matricula=?";
		Usuario usuario = null;
		PreparedStatement statement;		
		try {
			statement = conexao.prepareStatement(sql);
			statement.setString(1, matricula);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return new Usuario(rs.getInt("id"),rs.getString("nome"),rs.getString("sobrenome"),rs.getString("senha"), rs.getString("matricula"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return usuario;
	}	
}

