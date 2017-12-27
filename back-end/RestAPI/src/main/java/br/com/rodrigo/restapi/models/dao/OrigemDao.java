package br.com.rodrigo.restapi.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.restapi.models.Origem;
import br.com.rodrigo.restapi.utils.JdbcConnection;

public class OrigemDao {

	public Origem findByPk(Integer id) {
		String sql = "SELECT * FROM tb_origens WHERE idorig = ?";
		try {
			Connection conn = JdbcConnection.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.first()) {
				Origem origem = new Origem();
				origem.setId(rs.getInt("idorig"));
				origem.setDescricao(rs.getString("descorig"));
				return origem;
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Origem> findAll() {
		Connection conn;
		Statement stm;
		ResultSet rs;
		List<Origem> origens = new ArrayList<Origem>();
		String sql = "SELECT * FROM tb_origens";
		try {
			conn = JdbcConnection.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Origem orig = new Origem(
						rs.getInt("idorig"),
						rs.getString("descorig"));
				origens.add(orig);
			}
			rs.close();
			stm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return origens;
	}
}
