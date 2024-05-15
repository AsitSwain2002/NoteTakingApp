<%@page import="com.Dto.Note"%>
<%@page import="com.noteDao.NoteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/updateAndView.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@4.2.0/fonts/remixicon.css"
	rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Note View</title>
</head>

<body>
	<header>
		<nav></nav>
	</header>
	<main>
		<div class="mainContainer">
			<%
			String idParam = request.getParameter("id");
			int id = Integer.parseInt(idParam);
			NoteDao ndo = new NoteDao();
			Note note = ndo.fetchNoteById(id);
			%>
			<form action="noteModifyServlet" method="post">
				<input type="text" name="title" class="search"
					value="<%= note.getNoteTitle()%>">
				<textarea name="note" class="note"><%= note.getNote()%></textarea>
				
				 <div class="backAndDelete">
                   <a href="home.jsp"><div class="back">
						<i class="ri-arrow-left-fill"></i>
					</div> </a> 
					<div class="back1">
						<a href="deleteNote?id=<%= note.getId()%>">Delete</a>
					</div> 
                </div>
					<input type="submit" value="Modify" class="submit">
            </form>
        </div>

	</main>
</body>

</html>
