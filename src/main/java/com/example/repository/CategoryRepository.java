package com.example.repository;

import com.example.entity.Category;
import com.example.utils.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryRepository {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public CategoryRepository(SessionFactory sessionFactory) {
    }

    public Category save(Category category) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(category);
                transaction.commit();
                return category;
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public void update(Category category) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(category);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public Category findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Category.class, id);
        }
    }

    public List<Category> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM categoryEntity", Category.class);
            return query.getResultList();
        }
    }

    public Category findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("SELECT c FROM categoryEntity c WHERE c.name = :name", Category.class);
            query.setParameter("name", name);
            List<Category> categories = query.getResultList();
            if (categories.isEmpty()) {
                return null;
            }
            return categories.get(0);
        } catch (NoResultException e) {
            return null;
        }
    }


}
