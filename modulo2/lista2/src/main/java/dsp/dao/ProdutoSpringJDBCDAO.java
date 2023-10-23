package dsp.dao;

import dsp.entity.Produto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
@Primary
@Slf4j
public class ProdutoSpringJDBCDAO implements ProdutoDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public ProdutoSpringJDBCDAO() { }
	
	public void save(Produto entity) {
		String insert_sql = "insert into produto (codigo, descricao, preco, qtdEstoque) values (:codigo, :descricao, :preco, :qtdEstoque)";
		String update_sql = "update produto set codigo = :codigo, descricao = :descricao, preco = :preco, qtdEstoque = :qtdEstoque where id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("codigo", entity.getCodigo())
				.addValue("descricao", entity.getDescricao())
				.addValue("preco", entity.getPreco())
				.addValue("qtdEstoque", entity.getQtdEstoque());
		if (entity.getId() == null) {
			jdbcTemplate.update(insert_sql, params);
		} else {
			params.addValue("id", entity.getId());
			jdbcTemplate.update(update_sql, params);
		}
	}

	public void delete(int id) {
		String sql = "delete from produto where id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", id);
		jdbcTemplate.update(sql, params);
	}

	public Produto find(int id) {
		Produto pr = null;
		try {
			String sql = "select * from produto where id = :id";
			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("id", id);
			pr = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> map(rs));
		} catch (EmptyResultDataAccessException e) {
			log.debug(e.getMessage());
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
		String sql = "select * from produto";
		System.out.println("testeasdfn");
		return jdbcTemplate.query(sql, (rs, rowNum) -> map(rs));
	}

	public Produto findByCodigo(String codigo) {
		Produto pr = null;
		try {
			String sql = "select * from produto where codigo = :codigo";
			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("codigo", codigo);
			pr = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> map(rs));
		} catch (EmptyResultDataAccessException e) {
			log.debug(e.getMessage());
		}
		return pr;
	}

	public List<Produto> findByDescricao(String descricao) {
		String sql = "select * from produto where upper(descricao) like :descricao";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("descricao", "%" + descricao.toUpperCase() + "%");
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> map(rs));
	}

	public List<Produto> findByPreco(float preco) {
			String sql = "select * from produto where preco <= :preco";
			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("preco", preco);
			return jdbcTemplate.query(sql, params, (rs, rowNum) -> map(rs));
	}

	public List<Produto> findByDataUltimaEntrada(Date dataInicial, Date dataFinal) {
		String sql = "select * from produto where dataUltimaEntrada between cast(:dataInicial as timestamp) and cast(:dataFinal as timestamp)";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("dataInicial", dataInicial)
				.addValue("dataFinal", dataFinal);
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> map(rs));
	}
	
}
