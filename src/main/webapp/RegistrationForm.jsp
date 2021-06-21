<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<!------ Include the above in your HEAD tag ---------->
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
@charset "ISO-8859-1";
body {
    background:#808080;
}
#login {
	-webkit-perspective: 1000px;
	-moz-perspective: 1000px;
	perspective: 1000px;
	margin-top:50px;
	margin-left:30%;
}
.login {
	font-family: 'Josefin Sans', sans-serif;
	-webkit-transition: .3s;
	-moz-transition: .3s;
	transition: .3s;
	-webkit-transform: rotateY(40deg);
	-moz-transform: rotateY(40deg);
	transform: rotateY(40deg);
}
.login:hover {
	-webkit-transform: rotate(0);
	-moz-transform: rotate(0);
	transform: rotate(0);
}
.login article {
	
}
.login .form-group {
	margin-bottom:17px;
}
.login .form-control,
.login .btn {
	border-radius:0;
}
.login .btn {
	text-transform:uppercase;
	letter-spacing:3px;
}
.input-group-addon {
	border-radius:0;
	color:#fff;
	background:#f3aa0c;
	border:#f3aa0c;
}
.forgot {
	font-size:16px;
}
.forgot a {
	color:#333;
}
.forgot a:hover {
	color:#5cb85c;
}

#inner-wrapper, #contact-us .contact-form, #contact-us .our-address {
    color: #1d1d1d;
    font-size: 19px;
    line-height: 1.7em;
    font-weight: 300;
    padding: 50px;
    background: #fff;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
    margin-bottom: 100px;
}
.input-group-addon {
    border-radius: 0;
        border-top-right-radius: 0px;
        border-bottom-right-radius: 0px;
    color: #fff;
    background: #f3aa0c;
    border: #f3aa0c;
        border-right-color: rgb(243, 170, 12);
        border-right-style: none;
        border-right-width: medium;
}
 
              .multicolortext {
        background-image: linear-gradient(to left, violet, indigo, green, blue, yellow, orange, red);
}
  
#message {
  background-color: yellow;
  position: fixed;
}

</style>  


    


</head>

<body>
<div  id="message" ></div>
<h3>REGISTER</h3>

						
<div class="col-md-4 col-md-offset-4" id="login">
						
						<section id="inner-wrapper" class="login">
							<article> 
							
							
								<form >
								<header>
           <h3>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="multicolortext">REGISTER</span>
		</h3>
        </header>
        	
        
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-user"> </i></span>
											<input type="text" class="form-control" id="userName"  placeholder="Name" pattern="[a-zA-Z]{3,20}" required autofocus>
										</div>
									</div>
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-envelope"> </i></span>
											
											
      	<input type="tel" class="form-control"  id="mobileNumber" size="10" minlength="10" maxlength="10" placeholder="Mobile Number" required autofocus>
										</div>
									</div>
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-key"> </i></span>
											<input type="password" class="form-control" id="createPassWord" placeholder="Password Eg:Prit@7172" pattern=".{8,20}" required autofocus>
										</div>
									</div>
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-key"> </i></span>
											<input type="password" class="form-control" id="confirmPassWord" placeholder="Confirm Password" pattern=".{8,20}" required autofocus>
										</div>
									</div>
									  <button type="submit" class="btn btn-success btn-block">Submit</button>
									  
		
			<button type="reset" class="btn btn-secondary btn-block">Reset</button>
			
        	<br>Already<a href="login.jsp" > User? </a>
        	<br>
        	
								</form>
								<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script src="/js/UserService.js"></script>
<script src="/js/RegisterComponent.js"></script>
								
							</article>
							</section>
						</div>
 -->
</body>
</html>