package dsp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dsp.entity.Produto;
import org.springframework.stereotype.Repository;

public class ProdutoListDAO implements ProdutoDAO {

	private List<Produto> produtos;
	
	private static int idProximo = 1;
	
	
	public ProdutoListDAO() {
		this.produtos = new ArrayList<Produto>();
	}
	
	public void save(Produto entity) {
		// Inserir um cliente se o id do objeto for 0.
		if (entity.getId() == 0) {
			entity.setId(idProximo++);
			produtos.add(entity);
		// Alterar um cliente se o id não for 0.
		} else {
			int posicaoNaLista = findIndex(entity.getId());
			produtos.set(posicaoNaLista, entity);
		}
	}

	public void delete(int id) {
		produtos.remove(find(id));
	}

	public Produto find(int id) {
		for (Produto pr : this.produtos) {
			if (pr.getId() == id) {
				return pr;
			}
		}
		return null;
	}

	private int findIndex(int id) {
		for (int i=0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public List<Produto> find() {
		return this.produtos;
	}

	public Produto findByCodigo(String codigo) {
		for (Produto pr : this.produtos) {
			if (pr.getCodigo().equals(codigo)) {
				return pr;
			}
		}
		return null;
	}

	public List<Produto> findByDescricao(String descricao) {
		List<Produto> result = new ArrayList<Produto>();
		for (Produto pr : this.produtos) {
			if (pr.getDescricao().contains(descricao)) {
				result.add(pr);
			}
		}
		return result;
	}

	public List<Produto> findByPreco(float preco) {
		List<Produto> result = new ArrayList<Produto>();
		for (Produto pr : this.produtos) {
			if (pr.getPreco() <= preco) {
				result.add(pr);
			}
		}
		return result;
	}

	public List<Produto> findByDataUltimaEntrada(Date dataInicial, Date dataFinal) {
		List<Produto> result = new ArrayList<Produto>();
		for (Produto pr : this.produtos) {
			if (pr.getDataUltimaEntrada().after(dataInicial) && pr.getDataUltimaEntrada().before(dataFinal)) {
				result.add(pr);
			}
		}
		return result;
	}
}
