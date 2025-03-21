package dao;


import entities.Magazine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class MagazineDAO extends GenericDAO<Magazine> {
    @PersistenceContext
    private EntityManager em;

    public List<Magazine> findAll() {
        return em.createQuery("SELECT m FROM Magazine m", Magazine.class).getResultList();
    }
}
