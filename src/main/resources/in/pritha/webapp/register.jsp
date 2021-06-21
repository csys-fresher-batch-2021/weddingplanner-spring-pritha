<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED - register</title>
</head>
<body>
<h3> Register </h3>
<form action="RegisterServlet" method="get">
			<label for="Username"><strong>USERNAME *</strong></label><br> <input
				type="text" name="Username" id="Username"
				title="Username must be lowercase characters and length should be(4-8)"
				placeholder="Username"  required autofocus>
			<br>
				
			
			<label for="Password"><strong>PAASWORD *</strong></label> <input
				type="password" name="Password"
				title="Your Password must be like this eg.Prit@7172" id="Password"
				placeholder="Password" required autofocus>
			<br>
			<button type="submit" class="btn btn-primary">submit</button>
			&nbsp; &nbsp;
			<button type="reset" class="btn btn-secondary">Reset</button>
			&nbsp; &nbsp;
			<br>
			<br>
			
	
	
		</form>
</body>
</html>