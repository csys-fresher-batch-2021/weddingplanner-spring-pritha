<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3> logout </h3>
<div id="errorMessage"></div>
<form onsubmit="logout()">
<label>Enter your user id to logout </label>
<input type="number" id="userid" >
<button type="submit">Submit</button>
</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script src="/js/LogoutService.js"></script>
<script src="/js/LogoutComponent.js"></script>
</body>
</html>