<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h3 id="heading"> REGISTER</h3>
<form onsubmit="register()">
<input type="text" id="userName"  placeholder="Name" pattern="[a-zA-Z]{3,20}" required autofocus>
<br><br><input type="tel"  id="mobileNumber" size="10" minlength="10" maxlength="10" placeholder="Mobile Number" required autofocus>
<br><br><input type="password"  id="createPassWord" placeholder="Password Eg:Prit@7172" pattern=".{8,20}" required autofocus>
<br><br><input type="password"  id="confirmPassWord" placeholder="Confirm Password" pattern=".{8,20}" required autofocus>
<br><br>
<button type="submit" class="btn btn-primary">Submit</button>
&nbsp; <button type="reset" class="btn btn-secondary">Reset</button>
			
        	<br><br>Already<a href="login.jsp" > User? </a>
        	<br>
        	
			</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script src="/js/UserService.js"></script>
<script src="/js/RegisterComponent.js"></script>

</body>
</html>