<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<h3> Login </h3>


<form onsubmit="login()">
			<label for="Username"><strong>USERNAME *</strong></label> <input
				type="text" name="userName" id="userName"
				title="Username must be lowercase characters and length should be(4-8)"
				placeholder="Username"  required autofocus>
			<br><br>
				
			
			<label for="Password"><strong>PAASWORD *</strong></label> <input
				type="password" name="passWord"
				title="Your Password must be like this eg.Prit@7172" id="passWord"
				placeholder="Password" required autofocus>
			<br><br>
			<button type="submit" class="btn btn-primary">submit</button>
			&nbsp; &nbsp;
			<button type="reset" class="btn btn-secondary">Reset</button>
			&nbsp; &nbsp;
			<br>
			<br>
		</form>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script src="/js/UserService.js"></script>
<script src="/js/LoginComponent.js"></script>
		
		
</body>
</html>