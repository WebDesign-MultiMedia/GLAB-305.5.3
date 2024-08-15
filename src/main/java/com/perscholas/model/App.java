package com.perscholas.model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();
        Transaction x = s.beginTransaction();

        Cohort Class1 = new Cohort("Java Developer", "14 Weeks");
        Cohort Class2 = new Cohort("FullStack Developer", "7 Weeks");
        Cohort Class3 = new Cohort("Python Developer", "12 Weeks");

        // Store Cohort / Class
        s.persist(Class1);
        s.persist(Class2);
        s.persist(Class3);

        // Create Cohort one / Class One
        Set<Cohort> ClassSet1 = new HashSet<Cohort>();
        ClassSet1.add(Class2);
        ClassSet1.add(Class3);
        ClassSet1.add(Class1);

        // Create Cohort two / Class two
        Set<Cohort> ClassSet2 = new HashSet<Cohort>();
        ClassSet2.add(Class2);
        ClassSet2.add(Class3);
        ClassSet2.add(Class1);

        //Create Cohort Three / Class Three
        Set<Cohort> ClassSet3 = new HashSet<Cohort>();
        ClassSet3.add(Class3);
        ClassSet3.add(Class1);
        ClassSet3.add(Class2);

        Teacher t1 = new Teacher("100", "JULIO", ClassSet1);
        Teacher t2 = new Teacher("200", "Jenny", ClassSet2);
        Teacher t3 = new Teacher("200", "Charlie", ClassSet3);

        s.persist(t1);
        s.persist(t2);
        s.persist(t3);
        x.commit();






    }
}
