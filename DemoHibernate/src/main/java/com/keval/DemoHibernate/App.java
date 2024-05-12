package com.keval.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Alien obj = new Alien();
        obj.setAge(3);
        obj.setName("Patel");
        obj.setColor("Red");

//        Student student = new Student();
//        Laptop laptop = new Laptop();
//        student.setRollno(2);
//        student.setName("Nirali");
//        student.setMarks(99);
//        student.getLaptop().add(laptop);
//        laptop.setLid(102);
//        laptop.setLname("SamsungPro");
//        laptop.getStudent().add(student);

        Configuration con = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sf = con.buildSessionFactory();
        Session ses = sf.openSession();
        Transaction tx = ses.beginTransaction();



        Laptop laptop = new Laptop();
        Student student = new Student();
        student.setRollno(3);
        student.setName("Nirali");
        student.setMarks(99);
        student.getLaptop().add(laptop);
        laptop.setLid(102);
        laptop.setLname("SamsungPro");
        laptop.getStudent().add(student);

// Associate the student with the laptop
//        student.getLaptop().add(laptop);
//        laptop.getStudent().add(student);

// Save both the student and the laptop
        ses.save(student);
//        ses.save(laptop);

//        ses.save(obj);
//        ses.save(student);
//        ses.save(laptop);
        tx.commit();
        ses.close();
    }
}
