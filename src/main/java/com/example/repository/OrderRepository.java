package com.example.repository;

import com.example.entity.Order;
import com.example.utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class OrderRepository {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public OrderRepository(SessionFactory sessionFactory) {
    }

    public Order save(Order order) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(order);
                transaction.commit();
                return order;
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public void update(Order order) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(order);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public Order findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Order.class, id);
        }
    }

    public List<Order> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM orderEntity", Order.class);
            return query.getResultList();
        }
    }

    public List<Order> findOrderByDateRange(LocalDate startDate, LocalDate endDate) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("SELECT o FROM orderEntity o WHERE o.orderDate BETWEEN :startDate AND :endDate", Order.class);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            return query.getResultList();
        }
    }

}