package com.example.repository;

import com.example.entity.User;
import com.example.utils.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserRepository {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public UserRepository(SessionFactory sessionFactory) {
    }

    public User save(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(user);
                transaction.commit();
                return user;
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public void update(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(user);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
    }

    public User findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM userEntity", User.class);
            return query.getResultList();
        }
    }

    public User findByUserName(String userName) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("SELECT u FROM userEntity u WHERE u.userName = :userName", User.class);
            query.setParameter("userName", userName);
            List<User> users = query.getResultList();
            if (users.isEmpty()) {
                return null;
            }
            return users.get(0);
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<User> findByActive(Boolean isActive) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("SELECT u FROM userEntity u WHERE u.isActive = :isActive", User.class);
            query.setParameter("isActive", isActive);
            return query.getResultList();
        }
    }


}
