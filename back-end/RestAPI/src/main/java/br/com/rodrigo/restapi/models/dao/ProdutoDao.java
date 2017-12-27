package br.com.rodrigo.restapi.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.restapi.models.Produto;
import br.com.rodrigo.restapi.utils.JdbcConnection;

public class ProdutoDao {

	public List<Produto> findAll() {
		Connection conn;
		Statement stm;
		ResultSet rs;
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "SELECT * FROM tb_produtos";
		try {
			conn = JdbcConnection.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Produto prod = new Produto(
						rs.getInt("idprod"),
						rs.getString("proddesc"),
						rs.getDate("proddtcompra"),
						rs.getString("prodimage"),
						rs.getDouble("prodpreco"),
						rs.getInt("prodorigem"),
						rs.getInt("prodcat"));
				produtos.add(prod);
			}
			rs.close();
			stm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	public boolean save(Produto produto) {
		Connection conn;
		PreparedStatement pstm;
		String sql = "INSERT INTO tb_produtos(proddesc, proddtcompra, prodpreco, prodimage, prodorigem, prodcat) VALUES(?,?,?,?,?,?)";
		try {
			conn = JdbcConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, produto.getDescricao());
			pstm.setDate(2, produto.getDataCompra());
			pstm.setDouble(3, produto.getPreco());
			pstm.setString(4, produto.getImagem());
			pstm.setInt(5, produto.getOrigem().getId());
			pstm.setInt(6, produto.getCategoria().getId());
			int result = pstm.executeUpdate();
			if (result > 0) {
				return true;
			}
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Produto findByPK(Integer id) {
		Connection conn;
		PreparedStatement pstm;
		ResultSet rs;
		String sql = "SELECT * FROM tb_produtos WHERE idprod = ?";
		try {
			conn = JdbcConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			if (rs.first()) {
				Produto prod = new Produto(
						rs.getInt("idprod"),
						rs.getString("proddesc"),
						rs.getDate("proddtcompra"),
						rs.getString("prodimage"),
						rs.getDouble("prodpreco"),
						rs.getInt("prodorigem"),
						rs.getInt("prodcat"));
				return prod;
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean remove(Integer id) {
		Connection conn;
		PreparedStatement pstm;
		String sql = "DELETE FROM tb_produtos WHERE idprod = ?";
		try {
			conn = JdbcConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			int result = pstm.executeUpdate();
			if (result > 0) {
				return true;
			}
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Produto produto) {
		Connection conn;
		PreparedStatement pstm;
		String sql = "UPDATE tb_produtos SET proddesc = ?, proddtcompra = ?, prodpreco = ?, prodimage = ?, prodorigem = ?, prodcat = ? WHERE idprod = ?";
		try {
			conn = JdbcConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, produto.getDescricao());
			pstm.setDate(2, produto.getDataCompra());
			pstm.setDouble(3, produto.getPreco());
			pstm.setString(4, produto.getImagem());
			pstm.setInt(5, produto.getOrigem().getId());
			pstm.setInt(6, produto.getCategoria().getId());
			pstm.setInt(7, produto.getId());
			int result = pstm.executeUpdate();
			if (result > 0) {
				return true;
			}
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
