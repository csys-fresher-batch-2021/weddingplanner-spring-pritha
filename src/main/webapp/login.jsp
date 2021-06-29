<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet" id="bootstrap-css">
<style>
#heading {
	color: #2E8B57;
}
</style>


</head>
<body>
<h3 id="heading"> Login </h3>


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
			<button type="submit" class="btn btn-primary">Submit</button>
			&nbsp; &nbsp;
			<button type="reset" class="btn btn-secondary">Reset</button>
			&nbsp; &nbsp;
			<br>
			<br><br>New<a href="register.jsp" > User? </a>
			&nbsp; &nbsp;Forgot<a href="forgetpassword.jsp" > Password? </a>
			</form>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script src="/js/UserService.js"></script>
<script src="/js/LoginComponent.js"></script>
		
		
</body>
</html>