package many_to_many_bi_std_course.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_many_bi_std_course.dto.Course;
import many_to_many_bi_std_course.dto.Student;

public class MainClass {

	public static void main(String[] args) {
		Student s1= new Student();
		s1.setId(1);
		s1.setName("Raj");
		s1.setPhone(741852);
		
		Student s2= new Student();
		s2.setId(2);
		s2.setName("Rajesh");
		s2.setPhone(987466);
		
		Student s3= new Student();
		s3.setId(3);
		s3.setName("Ramu");
		s3.setPhone(987468);
		
		Course c1= new Course();
		c1.setC_id(101);
		c1.setName("JAVA");
		c1.setDuration("2 months");
		
		Course c2= new Course();
		c2.setC_id(102);
		c2.setName("ADV JAVA");
		c2.setDuration("1.5 months");
		
		Course c3= new Course();
		c3.setC_id(103);
		c3.setName("SQL");
		c3.setDuration("1 month");
		
		List<Course> list1= new ArrayList<Course>();
		list1.add(c1);
		list1.add(c2);
		
		
		List<Course> list2= new ArrayList<Course>();
		list2.add(c1);
		list2.add(c2);
		list2.add(c3);
		
		
		List<Student> stdList1= new ArrayList<Student>();
		stdList1.add(s1);
		stdList1.add(s2);
		
		List<Student> stdList2= new ArrayList<Student>();
		stdList2.add(s1);
		stdList2.add(s2);
		stdList2.add(s3);
		
		List<Student> stdList3= new ArrayList<Student>();
		stdList3.add(s3);
		
		c1.setStudents(stdList2);
		c2.setStudents(stdList1);
		c3.setStudents(stdList3);
		
		s1.setCourses(list1);
		s2.setCourses(list1);
		s3.setCourses(list2);
		
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vinod");
		EntityManager enEntityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= enEntityManager.getTransaction();
		entityTransaction.begin();
		enEntityManager.persist(c1);
		enEntityManager.persist(c2);
		enEntityManager.persist(c3);
		enEntityManager.persist(s1);
		enEntityManager.persist(s2);
		enEntityManager.persist(s3);
		entityTransaction.commit();
		System.out.println("Saved successfully");

	}

}
