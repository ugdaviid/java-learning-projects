package hu.david.studentmanager.dao;

import  hu.david.studentmanager.model.Student;
import  hu.david.studentmanager.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentDAO {

    public void save(Student student) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public List<Student> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Student> result = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();

        em.close();

        return result;
    }

    public Student findById(Long id) {

        EntityManager em =
                JPAUtil.getEntityManagerFactory()
                        .createEntityManager();

        Student student = em.find(Student.class, id);

        em.close();

        return student;
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        em.getTransaction().begin();

        Student s = em.find(Student.class, id);

        if (s != null) {
            em.remove(s);
        }

        em.getTransaction().commit();
        em.close();
    }

    public void update(Student student) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

}
