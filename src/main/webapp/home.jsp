<%@page import="com.noteDao.NoteDao"%>
<%@page import="com.Dto.Note"%>
<%@page import="java.util.List"%>
<%@page import="com.Dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@4.2.0/fonts/remixicon.css"
	rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>

<body>
	<header>
		<nav></nav>
	</header>
	<main>
		<div class="mainContainer">
			<%
			NoteDao ndo = new NoteDao();
			List<Note> note = ndo.fetchAllNotes();
			if (ndo != null && note != null) {
				for (Note n : note) {
			%>
			<a href="updateAndView.jsp?id=<%= n.getId()%>" class="anchor"><div
					class="note">
					<%=n.getNoteTitle()%>
				</div> </a>
			<%
			}
			}
			%>
		</div>
		<div class="addIcon">
			<a href="note.jsp"> <i class="ri-add-large-line"></i>
			</a>
		</div>
	</main>
</body>

</html>