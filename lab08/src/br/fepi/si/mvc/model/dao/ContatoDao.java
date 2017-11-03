package br.fepi.si.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.fepi.si.mvc.model.Contato;

/**
 * 
 * @author Leandro
 *
 */
public class ContatoDao {
	
	private Connection c;
	
	public ContatoDao(){
		c = new DataSource().getConnetion();
	}
	/**
	 * Insert
	 * @param contato
	 */
	public void insert (Contato contato){
		String sql = "insert into contatos"+
				"(nome,email,endereco,dataNascimento)"+
				"values(?,?,?,?)";
	try{	
		PreparedStatement stmt = c.prepareStatement(sql);
		
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new java.sql.Date (contato.getDataNascimento().getTimeInMillis()));
		
		
		//executandp
		stmt.execute();
		c.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
	
	/**
	 * Update
	 * @param contato
	 */
	public void update (Contato contato, Long id){
		String sql = "update contatos "+
						"set nome=?,email=?,endereco=?,dataNascimento=?"+
						"where id=?";
	try{	
		PreparedStatement stmt = c.prepareStatement(sql);
				
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new java.sql.Date (contato.getDataNascimento().getTimeInMillis()));
		stmt.setLong(5, id);
				
		//executandp
		stmt.execute();
		c.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
				}
		}	
	/**
	 * Delete
	 * @param contato
	 */
	
	public void delete (Long id){
		String sql = "delete from contatos where id=?";	
		
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			
			stmt.setLong(1, id);
			
			stmt.execute();
			c.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}

	
	public List<Contato> selectAll(){
		try{
			List<Contato> contatos = new ArrayList<>();
			PreparedStatement stmt = c.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				// criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				// guardando na lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			c.close();
			return contatos;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	public Contato selectId(long id) throws SQLException{
		String sql = "select * from contatos where id=?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		rs.next();
		Contato contato = new Contato();
		contato.setId(rs.getLong("id"));
		contato.setNome(rs.getString("nome"));
		contato.setEmail(rs.getString("email"));
		contato.setEndereco(rs.getString("endereco"));
		// montando a data através do Calendar
		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataNascimento"));
		contato.setDataNascimento(data);
		
		rs.close();
		stmt.close();
		c.close();
		
		return contato;			
		
	}

}
