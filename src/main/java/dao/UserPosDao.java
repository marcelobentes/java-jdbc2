package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDao {
	
	private Connection connection;

	public UserPosDao() {
		
		connection = SingleConnection.getConnection();
	}
	
	public void salvar ( Userposjava userposjava) {//metedo de salvar no banco
		
		try {
			
			String sql = "insert into userposjava (nome, email) values (?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);/* Faz o insert no banco*/
			/*Inserindo os dados na tabela*/
			
			insert.setString(1, userposjava.getNome());
			insert.setString(2, userposjava.getEmail());
			insert.execute(); /*executar no banco.*/
			connection.commit();//salva no banco
			
		} catch (Exception e) {
			try {
				connection.rollback();//reverte operação
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	/*Metodo de consulta no banco*/
	public List<Userposjava> listar () throws Exception{
		List<Userposjava> list = new ArrayList<Userposjava>();
		
		String sql = "select * from userposjava";//montando o sql
		
		PreparedStatement consulta = connection.prepareStatement(sql);//instancia a consulta
		ResultSet resultado = consulta.executeQuery();
		
		while(resultado.next()) {
			
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			
			list.add(userposjava);
			
		}
		
		
		return list;
	}
	
	//buscar no banco
	public Userposjava buscar (Long id) throws Exception{
		Userposjava retorno = new Userposjava();
		
		String sql = "select * from userposjava where id = " + id;//montando o sql
		
		PreparedStatement consulta = connection.prepareStatement(sql);//instancia a consulta
		ResultSet resultado = consulta.executeQuery();
		
		while(resultado.next()) {//vai retorna um ou nenhum
			
			
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
			
					
		}
		
		
		return retorno;
	}
	//metedo de atuazilar o banco
	public void atualizar (Userposjava userposjava) {
		
		try {
			
		
		String sql = "update userposjava set nome = ? where  id = " + userposjava.getId();//montando o sql
		PreparedStatement atualizarjdbc = connection.prepareStatement(sql);//instancia para atualizar
		atualizarjdbc.setString(1, userposjava.getNome());//informando a posição para setar
		atualizarjdbc.execute();
		connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void deletar (Long id) {
		
		try {
			
			String sql = "delete from userposjava where id = "+ id;
			PreparedStatement deleta = connection.prepareStatement(sql);
			deleta.execute();
			connection.commit();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		e.printStackTrace();
		
		}
		
	}

}
