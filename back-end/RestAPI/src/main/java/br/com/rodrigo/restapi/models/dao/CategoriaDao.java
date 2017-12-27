package br.com.rodrigo.restapi.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.restapi.models.Categoria;
import br.com.rodrigo.restapi.utils.JdbcConnection;

public class CategoriaDao {

	public Categoria findByPk(Integer id) {
		String sql = "SELECT * FROM tb_categorias WHERE idcat = ?";
		try {
			Connection conn = JdbcConnection.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.first()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("idcat"));
				categoria.setDescricao(rs.getString("desccat"));
				return categoria;
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Categoria> findAll() {
		Connection conn;
		Statement stm;
		ResultSet rs;
		List<Categoria> categorias = new ArrayList<Categoria>();
		String sql = "SELECT * FROM tb_categorias";
		try {
			conn = JdbcConnection.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Categoria cat = new Categoria(
						rs.getInt("idcat"),
						rs.getString("desccat"));
				categorias.add(cat);
			}
			rs.close();
			stm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}
}
