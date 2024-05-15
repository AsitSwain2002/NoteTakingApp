<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up</title>
<link rel="stylesheet" href="css/register.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.googleapis.com">
<%@ include file="components/bootstrapCss.jsp"%>
</head>

<body>
	<%@ include file="components/indexnavbar.jsp"%>
	<main>
		<div class="MainContainer">
			<div class="subContainer1">

				<img src="img/signup.jpg" alt="">
			</div>
			<div class="subContainer2">
				<h2 class="header">Sign Up</h2>
				<form action="RegisterServlet" method="post">
					<label for="name" class="name-design">Full Name</label> <input
						type="text" name="name" class="block" placeholder="Name..">
					<label class="name-design">Age</label> <input type="text"
						name="age" class="block" placeholder="ex.20"> <label
						class="name-design">Mobile</label> <input type="tel" name="mobile"
						class="block" placeholder="9965874521"> <label
						class="name-design">Email</label> <input type="email" name="email"
						class="block" placeholder="asit52@gmail.com"> <label
						class="name-design">Password</label> <input type="password"
						name="password" class="block"> <input type="submit"
						value="Submit" class="sub">

				</form>
			</div>
		</div>
	</main>

</body>

</html>