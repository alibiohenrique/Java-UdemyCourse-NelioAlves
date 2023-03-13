	package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.People;

public class Program {

	public static void main(String[] args) {
//		People p1 = new People(null, "Carlos da silva ", "carlos@gmail.com");
//		People p2 = new People(null, "Isaiah da silva ", "isaiah@gmail.com");
//		People p3 = new People(null, "Joana da silva ", "joana@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager em = emf.createEntityManager();
		
//		People p = em.find(People.class, 2);
//		System.out.println(p);
		
		People p = em.find(People.class, 2);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
//		em.getTransaction().begin();
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		em.getTransaction().commit();
		System.out.println("Done! ");
//		
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
		
		em.close();
		emf.close();

	}

}
