<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-cancelbooking</title>
<style>
    #heading { color: #2E8B57; } /*green*/

</style>
</head>
<body>
	<br><br>
<h3 id="heading">**** CANCELLED BOOKING!****</h3>
<br>
<form onsubmit="cancelBooking()">
<input id="heading" type="button"  value="REASON FOR CANCELLATION" />
&nbsp; &nbsp;
<input class="hide" type="text" name="reason" id="reason" required autofocus >





<button type="submit" class="btn btn-success">Submit</button>
<br> 

</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script src="/js/BookingService.js"></script>
<script src="/js/BookingComponent.js"></script>

</body>
</html>