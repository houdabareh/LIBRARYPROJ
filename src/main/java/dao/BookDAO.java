package dao;



import entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class BookDAO extends GenericDAO<Book> {
    @PersistenceContext
    private EntityManager em;

    public List<Book> findAll() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }
}
