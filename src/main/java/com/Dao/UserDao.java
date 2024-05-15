package com.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Dto.User;

public class UserDao {
	public void saveUser(User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(user);
		et.commit();

	}

	public User fetchUserByEmail(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select a from User a where a.email = ?1");
		query.setParameter(1, email);
		List<User> li = query.getResultList();
		for (User user : li) {
			User user1 = new User();
			user1.setName(user.getName());
			user1.setAge(user.getAge());
			user1.setMobile(user.getMobile());
			user1.setEmail(user.getEmail());
			user1.setPassword(user.getPassword());
			user1.setId(user.getId());

			return user1;

		}
		return null;

	}

	public List<User> fetchAllUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("select a from User a");
		List rl = query.getResultList();
		return rl;
	}

	public User fetchUserById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
		EntityManager em = emf.createEntityManager();

		User user = em.find(User.class, id);
		return user;

	}

	public void updateUserDetails(int id, String name, int age, long mobile, String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		User user = em.find(User.class, id);
		if (user != null) {
			et.begin();
			user.setName(name);
			user.setAge(age);
			user.setMobile(mobile);
			user.setEmail(email);
			em.merge(user);
			et.commit();
		}
	}

	public void updatePas(int id ,String newPas) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		User user = em.find(User.class, id);
		user.setPassword(newPas);
		et.begin();
		em.merge(user);
		et.commit();

	}
	public void deleteUser(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		User user = em.find(User.class, id);
		
		et.begin();
		em.remove(user);
		et.commit();
	}

}
