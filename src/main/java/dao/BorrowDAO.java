package dao;


import entities.Borrow;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class BorrowDAO extends GenericDAO<Borrow> {
    @PersistenceContext
    private EntityManager em;

    public List<Borrow> findAll() {
        return em.createQuery("SELECT b FROM Borrow b", Borrow.class).getResultList();
    }
}
