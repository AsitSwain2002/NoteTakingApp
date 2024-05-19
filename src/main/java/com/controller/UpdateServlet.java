package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dto.Note;
import com.noteDao.NoteDao;

@WebServlet("/noteModifyServlet")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String note = req.getParameter("note");
		String noteTitle = req.getParameter("title");
		
		NoteDao ndo = new NoteDao();
		
		//fetch the note
		Note fetchNoteById = ndo.fetchNoteById(id);
		//add the updated note
		fetchNoteById.setNote(note);
		fetchNoteById.setNoteTitle(noteTitle);
		//save this note
		ndo.saveAndUpdateNote(fetchNoteById);
		resp.sendRedirect("home.jsp");
	}

}
