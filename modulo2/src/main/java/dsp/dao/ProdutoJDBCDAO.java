package dsp.dao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dsp.entity.Produto;

public class ProdutoJDBCDAO implements ProdutoDAO {

	public ProdutoJDBCDAO() { }
	
	public void save(Produto entity) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into mod2atv1.produto (codigo, descricao, preco, qtdEstoque) values (?, ?, ?, ?)";
			String update_sql = "update mod2atv1.produto set codigo = ?, descricao = ?, preco = ?, qtdEstoque = ? where id = ?";
			PreparedStatement pst;
			if (entity.getId() == 0) {
				pst = con.prepareStatement(insert_sql);
			} else {
				pst = con.prepareStatement(update_sql);
				pst.setInt(5, entity.getId());
			}
			pst.setString(1, entity.getCodigo());
			pst.setString(2, entity.getDescricao());
			pst.setFloat(3, entity.getPreco());
			pst.setInt(4, entity.getQtdEstoque());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
	}

	public void delete(int id) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from mod2atv1.produto where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
	}

	public Produto find(int id) {
		Connection con = null;
		Produto pr = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select * from mod2atv1.produto where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				pr = map(rs);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return pr;
	}

	private Produto map(ResultSet rs) throws SQLException {
		Produto pr = new Produto();
		pr.setId(rs.getInt("id"));
		pr.setCodigo(rs.getString("codigo"));
		pr.setDescricao(rs.getString("descricao"));
		pr.setPreco(rs.getFloat("preco"));
		pr.setQtdEstoque(rs.getInt("qtdEstoque"));
		pr.setDataUltimaEntrada(rs.getDate("dataUltimaEntrada"));
		return pr;
	}

	public List<Produto> find() {
		Connection con = null;
		List<Produto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from mod2atv1.produto";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Produto>();
			while (rs.next()) {
				Produto pr = map(rs);
				result.add(pr);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}

	public Produto findByCodigo(String codigo) {
		Connection con = null;
		Produto pr = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from mod2atv1.produto where codigo = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				pr = map(rs);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return pr;
	}

	public List<Produto> findByDescricao(String descricao) {
		Connection con = null;
		List<Produto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from mod2atv1.produto where descricao like ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+descricao+"%");
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Produto>();
			while (rs.next()) {
				Produto pr = map(rs);
				result.add(pr);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}

	public List<Produto> findByPreco(float preco) {
		Connection con = null;
		List<Produto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from mod2atv1.produto where preco <= ?";
			pst = con.prepareStatement(sql);
			pst.setFloat(1, preco);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Produto>();
			while (rs.next()) {
				Produto pr = map(rs);
				result.add(pr);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}

	public List<Produto> findByDataUltimaEntrada(Date dataInicial, Date dataFinal) {
		Connection con = null;
		List<Produto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from mod2atv1.produto where dataUltimaEntrada between cast(? as timestamp) and cast(? as timestamp)";
			pst = con.prepareStatement(sql);
			pst.setString(1, dataInicial.toString());
			pst.setString(2, dataFinal.toString());
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Produto>();
			while (rs.next()) {
				Produto pr = map(rs);
				result.add(pr);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}
	
}
