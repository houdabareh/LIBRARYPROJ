package dao;



import entities.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class DocumentDAO extends GenericDAO<Document> {
    @PersistenceContext
    private EntityManager em;

    public List<Document> findAll() {
        return em.createQuery("SELECT d FROM Document d", Document.class).getResultList();
    }
}
