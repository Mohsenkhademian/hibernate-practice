package com.example.repository;

import com.example.entity.Product;
import com.example.utils.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductRepository {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ProductRepository(SessionFactory sessionFactory) {
    }

    public Product save(Product product) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(product);
                transaction.commit();
                return product;
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public void update(Product product) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(product);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public Product findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, id);
        }
    }

    public List<Product> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("SELECT p FROM productEntity p", Product.class);
            return query.getResultList();
        }
    }

    public Product findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("SELECT p FROM productEntity p WHERE p.name = :name", Product.class);
            query.setParameter("name", name);
            List<Product> products = query.getResultList();
            if (products.isEmpty()) {
                return null;
            }
            return products.get(0);
        } catch (NoResultException e) {
            return null;
        }
    }


}
