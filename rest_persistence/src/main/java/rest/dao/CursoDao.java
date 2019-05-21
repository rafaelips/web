package rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rest.model.Curso;
import rest.util.DbUtil;

public class CursoDao {
	
	private static final String CURSO = "curso";
	private static final String IDCURSOS = "idcursos";
	private static Connection conexao = DbUtil.getConnection();
	private static String nomeTabela = "cursos";
	
	public static Curso getCurso(int id_curso) {
		String sql = "SELECT * FROM "+nomeTabela+" WHERE idcursos=?";
		Curso curso= null;
		try {
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setInt(1, id_curso);
			ResultSet result = statement.executeQuery();
			curso = getCurso(result);
		} catch (SQLException e) { 
			e.printStackTrace();
		}		
		return curso;	
	}	
	
	public static void deletar(int id_curso) {
		String sql = "DELETE FROM "+nomeTabela+" WHERE "+IDCURSOS+"=?";
		PreparedStatement statement;		
		try {
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, id_curso);
			statement.executeUpdate();
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}		
	}
		
	public static Curso adicionar(String nome) {
		String sql = "INSERT INTO "+nomeTabela+"(curso) VALUES (?)";
		Curso curso = null;
		PreparedStatement statement;		
		try {
			statement = conexao.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, nome);
			ResultSet result = statement.getGeneratedKeys();
			while (result.next()) 
			curso = getCurso(result);						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}
	
	
	public static Curso alterar(int id, String nome) {
		String sql = "UPDATE "+nomeTabela+" SET "+CURSO+"=? WHERE "+IDCURSOS+"=?";
		PreparedStatement statement;
		Curso curso= null;
		try {
			statement = conexao.prepareStatement(sql);
			statement.setString(1,nome);
			statement.setInt(2, id);
			statement.executeUpdate();
			ResultSet result = statement.getGeneratedKeys();
			curso = getCurso(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}
	
	public static List<Curso> getCursos(){
		String sql = "SELECT * FROM "+nomeTabela;
		List<Curso> cursos = new ArrayList<Curso>();
		
		Statement statement;
		ResultSet result;
		try {
			statement = conexao.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) 
				cursos.add(getCurso(result));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return cursos;			
	}

	private static Curso getCurso(ResultSet result) throws SQLException{
		if (result.next()) {
			return new Curso(result.getInt(IDCURSOS),result.getString(CURSO));
		}
		return null;		
	}
}
