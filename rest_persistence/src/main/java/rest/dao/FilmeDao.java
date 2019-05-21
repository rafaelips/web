package rest.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import rest.model.Filme;
import rest.util.DbUtil;

public class FilmeDao {
	
	private static Connection conexao = DbUtil.getConnection();
	private static String nomeTabela = "filme";
	
	public static List<Filme> getFilmes(){
		List<Filme> filmes = new ArrayList<Filme>();
		
		String sql = "SELECT * FROM "+nomeTabela;		
		try {
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {				
				filmes.add(new Filme(rs.getInt("idfilme"),rs.getString("nome_filme1") ,rs.getString("nome_filme2"),rs.getString("nome_filme3"),rs.getInt("status"),rs.getInt("voto_filme1") , rs.getInt("voto_filme2"), rs.getInt("voto_filme3")));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filmes;
	}
	
	private static Filme getFilme(int id) {
		
		String sql = "SELECT * FROM "+nomeTabela+ " WHERE idfilme=?";
		
		PreparedStatement pStmt;
		try {
			pStmt = conexao.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				return new Filme(rs.getInt("idfilme"), rs.getString("nome_filme1"),  rs.getString("nome_filme2"), rs.getString("nome_filme3"),  rs.getInt("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public static Filme cadastrar(String nome_filme1, String nome_filme2, String nome_filme3, InputStream arquivo1, InputStream arquivo2, InputStream arquivo3) {
		
		String sql = "INSERT INTO "+nomeTabela+" (nome_filme1, nome_filme2, nome_filme3, status, voto_filme1, voto_filme2, voto_filme3) VALUES (?,?,?,?,?,?,?)";						
				
		try {
			PreparedStatement statement = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
						
			statement.setString(1, nome_filme1);
			statement.setString(2, nome_filme1);
			statement.setString(3, nome_filme1);
			
			statement.setInt(4,0);
			statement.setInt(5,0);
			statement.setInt(6,0);
			statement.setInt(7,0);
			
			statement.execute();
			ResultSet rs = statement.getGeneratedKeys();
			
			while(rs.next()) {
				int id = rs.getInt(1);				
				uploadFile(arquivo1,id,nome_filme1);
				uploadFile(arquivo2,id,nome_filme2);
				uploadFile(arquivo3,id,nome_filme3);								
				return  getFilme(id);
			}						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
			
		return null;		
	}
		
	private static void uploadFile(InputStream uploadedInputStream, int id, String nome) {
		try {
			InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("uploads.properties");
			Properties prop = new Properties();
			prop.load(inputStream);
			String folder = prop.getProperty("folder");
			String filePath = folder +nome+id+".png";
			saveFile(uploadedInputStream, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void saveFile(InputStream uploadedInputStream, String serverLocation) {
		try {
			OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			outpuStream = new FileOutputStream(new File(serverLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
