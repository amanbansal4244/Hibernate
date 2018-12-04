package com.aman;
 
import java.util.ArrayList;
import java.util.List;
 
import org.hibernate.Session;
 
import com.aman.Student;
import com.aman.University;
 
public class HibernateStandAlone {
 
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
 
        Student student1 = new Student("Sam", "Disilva", "Maths");
        Student student2 = new Student("Joshua", "Brill", "Science");
        Student student3 = new Student("Peter", "Pan", "Physics");
 
        University university = new University("CAMBRIDGE", "ENGLAND");
        List<Student> allStudents = new ArrayList<Student>();
 
        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);
 
        allStudents.add(student1);
        allStudents.add(student2);
        allStudents.add(student3);
 
        university.setStudents(allStudents);
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        /**** Students will be persisted automatically, thanks to CASCADE.ALL defined on students property of University class.****/
        session.save(university);
        //session.persist(university); // this is also fine.
        
        //Using Bi-directional, we can access the University table data from Student table using only code.
        List<Student> students = (List<Student>) session.createQuery(
                "from Student ").list();
        for (Student s : students) {
            System.out.println("Student Details : " + s);
            System.out.println("Student University Details: "
                    + s.getUniversity());
        }
 
        session.getTransaction().commit();
        session.close();
    }
 
}
