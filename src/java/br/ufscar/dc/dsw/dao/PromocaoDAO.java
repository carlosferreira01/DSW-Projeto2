package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Promocao;
import br.ufscar.dc.dsw.pojo.Site;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PromocaoDAO extends GenericDAO<Promocao> {

    @Override
    public void save(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(promocao);
        tx.commit();
        em.close();
    }

    @Override
    public List<Promocao> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select p from Promocao p", Promocao.class);
        List<Promocao> promocoes = q.getResultList();
        em.close();
        return promocoes;
    }

    @Override
    public void delete(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        promocao = em.getReference(Promocao.class, promocao.getId());
        tx.begin();
        em.remove(promocao);
        tx.commit();
    }

    @Override
    public void update(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(promocao);
        tx.commit();
        em.close();
    }

    @Override
    public Promocao get(Long id) {
        EntityManager em = this.getEntityManager();
        Promocao promocao = em.find(Promocao.class, id);
        em.close();
        return promocao;
    }

    public List<Promocao> getById(Long id) {
        EntityManager em = this.getEntityManager();
        String sql = "select p from Promocao p where p.site.id = :id";
        TypedQuery<Promocao> q = em.createQuery(sql, Promocao.class);
        q.setParameter("id", id);
        return q.getResultList();
    }

    public List<Promocao> getByUrl(String url) {
        EntityManager em = this.getEntityManager();
        String sql = "SELECT p FROM Promocao p ";
        //       + "WHERE p.Url = :url";
        TypedQuery<Promocao> q = em.createQuery(sql, Promocao.class);
        // q.setParameter("url", url);
        return q.getResultList();
    }

    public List<String> getTeatros() {
        EntityManager em = this.getEntityManager();
        String sql = "SELECT t.nome FROM Teatro t JOIN Promocao p ON p.sala_id = t.id;";
        TypedQuery<String> q = em.createQuery(sql, String.class);
        return q.getResultList();
    }

    public List<Site> getSites() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("SELECT s FROM Site s", Promocao.class);
        List<Site> sites = q.getResultList();
        return q.getResultList();
    }

    public List<Promocao> getByTeatro(Long id) {
        EntityManager em = this.getEntityManager();
        String sql = "select p from Promocao p where p.teatro.id = :id";
        TypedQuery<Promocao> q = em.createQuery(sql, Promocao.class);
        q.setParameter("id", id);
        return q.getResultList();
    }
}
