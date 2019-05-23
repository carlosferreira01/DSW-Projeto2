package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Teatro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class TeatroDAO extends GenericDAO<Teatro>{
    
    @Override
    public void save(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teatro);
        tx.commit();
        em.close();
    }
    
    @Override
    public List<Teatro> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select l from Teatro t", Teatro.class);
        List<Teatro> teatros = q.getResultList();
        em.close();
        return teatros;
    }

    @Override
    public void delete(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        teatro = em.getReference(Teatro.class, teatro.getId());
        tx.begin();
        em.remove(teatro);
        tx.commit();
    }
    
    @Override
    public void update(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(teatro);
        tx.commit();
        em.close();
    }

    @Override
    public Teatro get(Long id) {
        EntityManager em = this.getEntityManager();
        Teatro teatro = em.find(Teatro.class, id);
        em.close();
        return teatro;
    }
    
    public Teatro getByCNPJ(String cnpj) {
        EntityManager em = this.getEntityManager();
        String sql = "SELECT s FROM Teatro t "
                + "WHERE s.CNPJ = :cnpj";
        TypedQuery<Teatro> q = em.createQuery(sql, Teatro.class);
        q.setParameter("cnpj", cnpj);
        return q.getSingleResult();
    }
    
    public List<Teatro> getByCity(String city) {
        EntityManager em = this.getEntityManager();
        String sql = "SELECT s FROM Teatro t "
                + "WHERE s.cidade = :city";
        TypedQuery<Teatro> q = em.createQuery(sql, Teatro.class);
        q.setParameter("city", city);
        return q.getResultList();
    }
}