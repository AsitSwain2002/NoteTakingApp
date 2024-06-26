package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.Dto.Note;
import com.Dto.User;
import com.noteDao.NoteDao;

@WebServlet("/noteServlet")
public class AddNoteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String title = req.getParameter("title");
		String noteServer = req.getParameter("note");

		Note note = new Note();
		note.setNoteTitle(title);
		note.setNote(noteServer);

		List<Note> notes = new ArrayList<Note>();
		notes.add(note);
		user.setNotes(notes);
         
		note.setUser(user);
		NoteDao ndo = new NoteDao();
		ndo.saveAndUpdateNote(note);

//		ndo.fetchAllNotes(user.getId());
		resp.sendRedirect("home.jsp");
	}
}
