package com.ra.session10.repository;

import com.ra.session10.model.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Student> getStudents() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Student",Student.class).getResultList();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Student findById(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean saveStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(student);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public  boolean deleteStudentById(long id){
        Student student = findById(id);
        if (student != null) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(student);
                transaction.commit();
                return true;
            } catch (Exception e) {
                return false;
            }
        }else {
            return false;
        }
    }
}