<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/note.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.2.0/fonts/remixicon.css" rel="stylesheet" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Note</title>
</head>

<body>
    <header>
        <nav></nav>
    </header>
    <main>
        <div class="mainContainer">
            <form action="noteServlet" method="post">
                    <input type="text" name="title" class="search" placeholder="Enter Title.." >
                    <textarea name="note" class="note" placeholder="Enter Note..."></textarea>
                    <input type="submit" value="Add" class="submit">
            </form>
        </div>

    </main>
</body>

</html>
