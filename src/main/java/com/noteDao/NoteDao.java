package com.noteDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Dto.Note;
import com.Dto.User;

public class NoteDao {

	public void saveAndUpdateNote(Note note) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(note);
		et.commit();
		
	}
	public List fetchAllNotes(int userId)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
		EntityManager em = emf.createEntityManager();
		
        Query query = em.createQuery("SELECT n FROM Note n WHERE n.user.id = :userId");
        query.setParameter("userId", userId);
		List list = query.getResultList();
		
		return list;
		
	}
	public Note fetchNoteById(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
		EntityManager em = emf.createEntityManager();
		Note note = em.find(Note.class, id);
		
		return note;
		
	}
	public void removeNoteById(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Asit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Note user = em.find(Note.class, id);
		
		et.begin();
		em.remove(user);
		et.commit();
	}
}
