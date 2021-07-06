<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-onlinepayment</title>
<style>
#heading {
	color: #FA8072;
}

img {
	max-width: 20%;
	height: 5%;
	position: relative;
	float: right;
}
</style>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script src="/js/BookingService.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://momentjs.com/downloads/moment.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css">
	<script src="/js/PaymentComponent.js"></script>
		<script src="/js/PaymentService.js"></script>

</head>
<body>

	<h3 id="heading">PAYMENT</h3>
	<br>



	

	



	<form>

		<strong>Please select your Bank:</strong> <input type="radio"
			id="bank1" name="bank_status" value="SBI"> <label for="bank1">SBI</label>
		<input type="radio" id="bank2" name="bank_status" value="CANARA">
		<label for="bank2">CANARA</label> <input type="radio" id="bank3"
			name="bank_status" value="HDFC"> <label for="bank3">HDFC</label>
		<input type="radio" id="bank4" name="bank_status" value="AXIS">
		<label for="bank4">AXIS</label><br>
		<p>
			i . Using canara bank , You may get <strong>flat 5% </strong>in your
			total
		</p>

		<label for="cardtypes"><strong>Choose a Card Type * </strong></label>
		<select name="cardtypes" id="card" required>
			<option disabled selected>Choose a Card type</option>
			<option value="Visa Card">Visa Card</option>
			<option value="Rupay Card">Rupay Card</option>
			<option value="Master Card">Master Card</option>
			<option value="Discover Card">Discover Card</option>
		</select> <br /> <label for="cardusername"><strong>Card User
				Name *</strong></label> <input type="text" name="cardusername" id="cardusername"
			placeholder="Username" pattern="[a-z]{8,30}" required autofocus>

		<br> <label for="ccn"><strong>Credit Card Number
				*</strong></label> <input name="ccn" id="ccn" type="tel" inputmode="numeric"
			pattern="[0-9\s]{13,16}" autocomplete="cc-number" maxlength="19"
			placeholder="xxxx xxxx xxxx xxxx"> <br> <em> Hint :
			*Card number must be 13-16 digits *numeric</em> <br> <label
			for="expirydate"><strong>Card Expiry Date * </strong> </label> <input
			name='expirydate' id='expirydate' type='date' value='2021-05-24'
			min='2021-05-24' required> &nbsp; <label for="cvv"><strong>Cvv
				*</strong></label> <input type="number" name="cvv" id="cvv" placeholder="123"
			pattern="[0-9]{3,4}" required autofocus> <br> <em>
			Note : Card Expiry Date should be atleast today!</em> 
			<br> <label
			for="amount"><strong>Amount *</strong></label> <input type='text' id='fares'  required autofocus> <br>
		
		<label for="purpose"><strong>Purpose Of Transaction</strong></label> <input
			type="text" name="purpose" id="purpose"
			placeholder="eg:Decoration amount paid" autofocus> <br>

		<br> <br>
		<button type="button" id="SubmitBtn" class="btn btn-primary">PROCEED></button>
		&nbsp; &nbsp;
		<button type="reset" class="btn btn-secondary">Reset !</button>
		&nbsp; &nbsp;


	
		
	</form>
	<br>
	<br />Do you want to check your
	<a href="bookingsummary.jsp"> last booking summary? </a>
	
	<script>
		$(document).ready(function(){
			console.log("Jquery Loaded");
			$("#SubmitBtn").on('click',checkPaymentDetails);
			$("#SubmitBtn").on('keyup',checkPaymentDetails);
			
			
			
		});
	</script>


</body>
</html>