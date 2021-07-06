<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>booking summary</title>
</head>
<body>
	<h3>Booking Summary</h3>
	<div class="progress">
		<div class="progress-bar progress-bar-striped bg-success"
			role="progressbar" style="width: 100%" aria-valuenow="25"
			aria-valuemin="0" aria-valuemax="100"></div>
	</div>
	<table class="table table-bordered">
		<caption>My Last Booking Summary</caption>
		<thead>
			<tr>
				<th scope="col">Wedding Date</th>
				<th scope="col">Wedding Time</th>
				<th scope="col">Wedding Location</th>
				<th scope="col">Wedding Style</th>
				<th scope="col">Weddingstyle Location</th>
				<th scope="col">Wedding FoodType</th>
				<th scope="col">Wedding Guest Count</th>
				<th scope="col">Wedding Decor type</th>
				<th scope="col">Status</th>
			</tr>
		</thead>
		<tbody id="booking-tbl">
		</tbody>
	</table>
	<br>
	<button type="button" value="goto"
		class="btn btn-info btn-lg float-left" onclick="bill()">CHECK BILL</button>
	
	<button type="button" value="goto"
		class="btn btn-danger btn-lg float-right" onclick="cancel()">CANCEL
		BOOKING </button>

	<br>
	<br>
	<p class="text-right">Note : You can cancel only from your wedding
		date of below 1 year</p>


	<script>
	let params = new URLSearchParams(location.search.substr(1));
	let bookingId = parseInt(params.get('bookingId')); //global scope
	console.log(bookingId);
	
		function displayBookingSummary(bookingId) {
			var details = JSON.parse(localStorage
					.getItem("VERIFIED_BOOKING_DETAILS"));
			/* let url ='GetBookingDetails/' + bookingId ;
			axios.get(url).then(res=>{
				let details = res.data;
				//move
			}); */
			console.log("Getting the local storage item");
			console.log(details);
			let content = "";

			content += "<tr>";
			
			//Sun Nov 21 2021 05:30:00 GMT+0530 (India Standard Time)	
			// ----> 21/11/2021
			var weddingDate = new Date(details.weddingDate);
			console.log(weddingDate);
			let formatted_date = weddingDate.getDate() + "-"
					+ (weddingDate.getMonth() + 1) + "-"
					+ weddingDate.getFullYear()
			console.log(formatted_date);
			content += "<td>" + formatted_date + "</td>";
			content += "<td>" + details.weddingTime + "</td>";
			content += "<td>" + details.weddingLocation + " </td>";
			content += "<td>" + details.weddingStyle + " </td>";
			content += "<td>" + details.weddingStyleLocation + " </td>";
			content += "<td> " + details.weddingFoodStyle + "</td>"
			content += "<td>" + details.weddingGuestCount + "</td>";
			content += "<td>" + details.weddingDecorTheme + "</td>";
			content += "<td bgcolor='green'>" + details.status + "</td>";
			content += "</tr>";

			console.log(content);
			document.querySelector("#booking-tbl").innerHTML = content;
			return details.weddingDate;

		}

		function bill(){
			alert(bookingId);
			window.location.href = "http://localhost:9090/Invoice.html?bookingId="+bookingId;
		}
		function cancel() {
			alert(bookingId);
			//weddingdate
			var weddingDate = displayBookingSummary();
			alert("weddingDate " + weddingDate);

			//getting year only
			var wedStr = weddingDate.toLocaleString().substring(2, 4);
			alert("wedStr " + wedStr);

			//current date + one year extension
			var today = new Date().getFullYear() + 1;
			var max = today.toLocaleString().substring(3, 5);
			alert("max " + max);

			//comapare two years 

			if (wedStr > max) {
				window.location.href = "http://localhost:9090/cancelbooking.jsp?bookingId="+bookingId;

			} else {

				alert("You can cancel only from your wedding date of below 1 year");
			}
		}
		displayBookingSummary(bookingId);
	</script>
</body>
</html>