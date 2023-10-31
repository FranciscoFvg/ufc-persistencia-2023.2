package dsp.dao;

import dsp.entity.Produto;
import jakarta.persistence.EntityManager;

import java.util.Date;
import java.util.List;

public class ProdutoJPADAO extends GenericJPADAO<Produto> implements ProdutoDAO {

    EntityManager em = JPAUtil.getEntityManager();

    public ProdutoJPADAO() {
        super(Produto.class);
    }

    public void delete(int id) {
        delete(new Produto(id));
    }

    public Produto find(int id) {
        return find(Integer.valueOf(id));
    }

    public Produto findByCodigo(String codigo) {
        Produto pr = em.createQuery("select p from Produto p where upper(p.codigo) like upper(:codigo)",
            Produto.class).setParameter("codigo", "%" + codigo + "%").getSingleResult();
        JPAUtil.closeEntityManager();
        return pr;
    }

    public List<Produto> findByDescricao(String descricao) {
        List<Produto> Produtos = em.createQuery("select p from Produto p where upper(p.descricao) like upper(:descricao)",
            Produto.class).setParameter("descricao", "%" + descricao + "%").getResultList();
        JPAUtil.closeEntityManager();
        return Produtos;
    }

    public List<Produto> findByPreco(float preco) {
        List<Produto> Produtos = em.createQuery("select p from Produto p where p.preco <= :preco",
                Produto.class).setParameter("preco", preco).getResultList();
        JPAUtil.closeEntityManager();
        return Produtos;
    }

    public List<Produto> findByDataUltimaEntrada(Date dataInicial, Date dataFinal) {
        List<Produto> Produtos = em.createQuery("select p from Produto p where p.dataUltimaEntrada between :dataInicial and :dataFinal",
                Produto.class).setParameter("dataInicial", dataInicial).setParameter("dataFinal", dataFinal).getResultList();
        JPAUtil.closeEntityManager();
        return Produtos;
    }
    
}
