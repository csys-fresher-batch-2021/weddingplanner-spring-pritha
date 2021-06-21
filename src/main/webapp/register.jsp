<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<h3> REGISTER</h3>
<div id="message"></div>
<form onsubmit="register()">
<input type="text" class="form-control" id="userName"  placeholder="Name" pattern="[a-zA-Z]{3,20}" required autofocus>
<br><br><input type="tel" class="form-control"  id="mobileNumber" size="10" minlength="10" maxlength="10" placeholder="Mobile Number" required autofocus>
<br><br><input type="password" class="form-control" id="createPassWord" placeholder="Password Eg:Prit@7172" pattern=".{8,20}" required autofocus>
<br><br><input type="password" class="form-control" id="confirmPassWord" placeholder="Confirm Password" pattern=".{8,20}" required autofocus>
<br><br>
<button type="submit" class="btn btn-success btn-block">Submit</button>
									 &nbsp; <button type="reset" class="btn btn-secondary btn-block">Reset</button>
			
        	<br><br>Already<a href="login.jsp" > User? </a>
        	<br>
        	
			</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script src="/js/UserService.js"></script>
<script src="/js/RegisterComponent.js"></script>

</body>
</html>