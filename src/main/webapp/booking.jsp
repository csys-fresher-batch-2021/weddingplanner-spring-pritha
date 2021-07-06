<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GRACEWED-booking</title>
<style>
#heading {
	color: #2E8B57;
}
</style>
</head>
<body>
	<h1 id="heading">BOOKING</h1>
	<br>
	<br />

	<form id="booking-details" onsubmit="checkBookingDetails()">
		<div class="row">

			<div class="col-6">
				
				<label for="weddingdate"><strong>Select
						Your Wedding Date *</strong> </label> <input name='wdate' id='wdate' type='date'
					value='2021-05-21' required>

				<script>
					function minDate() {
						var today = new Date();
						var dd = today.getDate();
						var mm = today.getMonth() + 1; //January is 0 so need to add 1 to make it 1!
						var yyyy = today.getFullYear();
						if (dd < 10) {
							dd = '0' + dd
						}
						if (mm < 10) {
							mm = '0' + mm
						}

						today = yyyy + '-' + mm + '-' + dd;
						document.getElementById("wdate").setAttribute("min",
								today);
					}
					minDate();
					
					
					function onTimeChange() {
						var inputEle = document.getElementById('wtime');
						console.log(inputEle);
						  var timeSplit = inputEle.value.split(':'),
						    hours,
						    minutes,
						    meridian;
						  hours = timeSplit[0];
						  minutes = timeSplit[1];
						  if (hours > 12) {
						    meridian = 'PM';
						    hours -= 12;
						  } else if (hours < 12) {
						    meridian = 'AM';
						    if (hours == 0) {
						      hours = 12;
						    }
						  } else {
						    meridian = 'PM';
						  }
						  var weddingTime = hours + ':' + minutes + ' ' + meridian;
						  console.log(weddingTime);
						  localStorage.setItem("time", weddingTime);
						
						}
				</script>
				<ul>
					<li><em> Note <br></br> Date should be above today!


					</em></li>
				</ul>
				<br> <label for="weddingtime"><strong>Select
						your Wedding Time *</strong></label> 
						<input name='wtime'  id="wtime"  onchange="onTimeChange()" type="time"
					value="04:00:00" min="04:00:00" max="16:00:00" required> <br>
				<br />
				
				<ul>
					<li><em> Note <br></br> Time should be between 4 AM to 4
							PM

					</em></li>
				</ul>
				<br /> <label><strong>Enter Your Wedding Location
						*</strong></label> <br /> <input type="text" name="wloc" id="wloc"
					placeholder="Your wedding location" required> <br /> <br />


			</div>

			<div class="col-6">
				<label for="weddingstyles"><strong>Choose a Wedding
						Style *</strong></label> <select name="weddingstyles" id="weddingstyles" required>
					<option disabled selected>Choose a Wedding Style</option>

					<option value="VintageStyle wedding">VintageStyle wedding</option>
					<option value="Traditional Wedding">Traditional Wedding</option>
					<option value="Informal Wedding">Informal Wedding</option>
					<option value="Formal Wedding">Formal Wedding</option>
					<option value="Festival Wedding">Festival Wedding</option>

				</select> <br /> <br /> <br /> <label for="weddinglocations"><strong>Choose
						a Wedding Location *</strong></label> <select name="locations" id="weddinglocations"
					required>
					<option disabled selected>Choose a Wedding Location</option>

					<option value="Stand Alone Bouquet Hall">Stand Alone
						Bouquet Hall</option>
					<option value="Hotel">Hotel</option>
					<option value="Temple/Mahal">Temple/Mahal</option>
					<option value="Museum">Museum</option>
					<option value="Historic site">Historic site</option>

				</select> <br /> <br /> <br /> <label for="Food"><strong>Choose
						Kind of Food *</strong></label> <select name="food" id="weddingfoodstyles" required>
					<option disabled selected>Choose Kind of Food</option>

					<option value="Family Style">Family Style</option>
					<option value="Plated Sit-Down">Plated Sit-Down</option>
					<option value="Buffet">Buffet</option>
					<option value="Cocktail-Style">Cocktail-Style</option>
					<option value="Food Stations">Food Stations</option>

				</select> <br /> <br /> <br /> <label for="guest"><strong>Choose
						Guest Count</strong></label> <select name="guest" id="weddingguestcounts" required>
					<option disabled selected>Choose Guest Count</option>
					<option value="10">10</option>
					<option value="50">50</option>
					<option value="100">100</option>
					<option value="500">500</option>
					<option value="1000">1000</option>
				</select> <br /> <em>Due to Current Pandemic Situation, Select upto
					100! </em> <br /> <br /> <br /> <label for="guest"><strong>Choose
						Decoration theme *</strong></label> <select name="decor" id="weddingdecorthemes" required>
					<option disabled selected>Choose Decoration theme</option>

					<option value="Romantic Garden">Romantic Garden</option>
					<option value="Vintage Travel">Vintage Travel</option>
					<option value="Lights-Camera-Action">Lights-Camera-Action</option>
					<option value="Under the Sea">Under the Sea</option>
					<option value="Magical forest">Magical forest</option>
				</select> <br />
				</div>
			</div>
<button type="submit" class="btn btn-primary" style="margin-left: 40%">submit</button>
</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script src="/js/BookingService.js"></script>
<script src="/js/BookingComponent.js"></script>


</body>
</html>