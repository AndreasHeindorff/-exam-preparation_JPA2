package Facade;

import Entity.Person;
import java.text.ParseException;
import Entity.Student;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andreas
 */
public class Facade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exam_preparation_JPA2PU");
    EntityManager em = emf.createEntityManager();
    
    public void createPerson(String firstName, String lastName, String birthDate, int age, boolean isMarried) {
        Person p = new Person(firstName, lastName, birthDate, age, isMarried);

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public void createStudent(int matNr, String matDate, String firstName, String lastName, String birthDate, int age, boolean isMarried) {
        Student s = new Student(matNr, matDate, firstName, lastName, birthDate, age, isMarried);

        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }
    
     public void editPerson(Long id, String firstName, String lastName, String birthDate, int age, boolean isMarried) {
        Person p = em.find(Person.class, id);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setBirthDate(birthDate);
        p.setAge(age);
        p.setIsMarried(isMarried);

        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }
     
     public void editStudent(Long id, String firstName, String lastName, String birthDate, int age, boolean isMarried, int matNr, String matDate) {
        Student s = em.find(Student.class, id);
        s.setFirstName(firstName);
        s.setLastName(lastName);
        s.setBirthDate(birthDate);
        s.setAge(age);
        s.setIsMarried(isMarried);
        s.setMatNr(matNr);
        s.setMatDate(matDate);

        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }

    

}
