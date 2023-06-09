package com.example.repository;

import com.example.entity.OrderItem;
import com.example.utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OrderItemRepository {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public OrderItemRepository(SessionFactory sessionFactory) {
    }

    public OrderItem save(OrderItem orderItem) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(orderItem);
                transaction.commit();
                return orderItem;
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public void update(OrderItem orderItem) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(orderItem);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public OrderItem findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(OrderItem.class, id);
        }
    }

    public List<OrderItem> findAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT oi FROM orderItemEntity oi";
            Query query = session.createQuery(hql, OrderItem.class);
            return query.getResultList();
        }
    }

    public List<OrderItem> findByQuantity(int quantity) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT oi FROM orderItemEntity oi WHERE oi.quantity = :quantity";
            Query query = session.createQuery(hql, OrderItem.class);
            query.setParameter("quantity", quantity);
            return query.getResultList();
        }
    }

}