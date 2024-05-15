package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.noteDao.NoteDao;

@WebServlet("/deleteNote")
public class DeleteNote extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		NoteDao ndo = new NoteDao();
		ndo.removeNoteById(id);
		resp.sendRedirect("home.jsp");
	}
}
