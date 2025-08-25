package com.ra.session10.repository;

import com.ra.session10.model.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Customer",Customer.class).getResultList();
        }catch (Exception e) {
            return null;
        }
    }

    public Customer findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Customer.class, id);
        }catch (Exception e) {
            return null;
        }
    }

    public boolean save(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean delete(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean checkEmailExisted(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select count(c) from Customer c where c.email = :email",Long.class)
                    .setParameter("email",email).uniqueResult()>0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkUsernameExisted(String username) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select count(c) from Customer c where c.username = :username",Long.class)
                    .setParameter("username",username).uniqueResult()>0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkPhoneExisted(String phone) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select count(c) from Customer c where c.phone = :phone",Long.class)
                    .setParameter("phone",phone).uniqueResult()>0;
        } catch (Exception e) {
            return false;
        }
    }
}
