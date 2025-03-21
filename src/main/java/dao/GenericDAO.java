package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;


public class GenericDAO<T> {
    @PersistenceContext
    protected EntityManager em;

    public void save(T entity) {
        em.persist(entity);
    }

    public T find(Class<T> clazz, Long id) {
        return em.find(clazz, id);
    }

    public List<T> findAll(Class<T> clazz) {
        return em.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e", clazz).getResultList();
    }

    public void update(T entity) {
        em.merge(entity);
    }

    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
