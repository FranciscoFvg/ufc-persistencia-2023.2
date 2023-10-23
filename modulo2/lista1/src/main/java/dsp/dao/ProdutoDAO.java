package dsp.dao;

import java.util.Date;
import java.util.List;

import dsp.entity.Produto;

public interface ProdutoDAO {
	
	public void save(Produto entity);
	
	public void delete(int id);
	
	public Produto find(int id);
	
	public List<Produto> find();
	
	public Produto findByCodigo(String codigo);
	public List<Produto> findByDescricao(String descricao);
	public List<Produto> findByPreco(float preco);
	public List<Produto> findByDataUltimaEntrada(Date dataInicial, Date dataFinal);

}
