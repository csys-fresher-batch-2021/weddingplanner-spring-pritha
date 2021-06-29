async function checkBookingDetails(){
	event.preventDefault();
	let weddingDate = document.querySelector("#wdate").value;
	/*let weddingDate = new Date(wedDate).toLocaleDateString();
	console.log(weddingDate);*/

	let weddingTime = localStorage.getItem("time");
	let weddingLocation = document.querySelector("#wloc").value;
	let weddingStyle = document.querySelector("#weddingstyles").value;
	let weddingStyleLocation = document.querySelector("#weddinglocations").value;
	let weddingFoodStyle = document.querySelector("#weddingfoodstyles").value;
	let weddingGuestCount = document.querySelector("#weddingguestcounts").value;
	let weddingDecorTheme = document.querySelector("#weddingdecorthemes").value;
	let status = "BOOKED";
	
	
	await BookingService.checkBookingDetails(weddingDate,weddingTime,weddingLocation,weddingStyle,weddingStyleLocation,
	weddingFoodStyle,weddingGuestCount,weddingDecorTheme,status).then(res=>{
		console.log(res.data);
		let bookingId = res.data.bookingId;
		
		let result = res.data;
		console.log(result);
		//if validate , move to summary page with boooking id
		//1-get from localstorgage and display the summary - done
		//2-with this booking id, get the info from db
		
		window.location.href="bookingsummary.jsp?bookingId="+ bookingId;
		
			
		
	})
	.catch(err=>{
		console.log(err);
		let data = err.response.data;
		document.querySelector("#message").innerHTML=data.errorMessage;
		console.log(data);
		//clear if invalid data and stay in same page
		window.localStorage.removeItem('VERIFIED_BOOKING_DETAILS');
		window.location.href="booking.jsp";
		
		
		
	});
}



function cancelBooking(){
event.preventDefault();
	let username = JSON.parse(localStorage.getItem("VERIFIED_LOGGED_IN_USER")).userName;
	console.log(username);
	let params = new URLSearchParams(location.search.substr(1));
	let bookingId = parseInt(params.get('bookingId')); //global scope
	console.log(bookingId);
	let status = "CANCELLED";
	let cancellationReason =  document.querySelector("#reason").value;
	let cancelledDate = new Date();
	BookingService.cancelBooking(username,bookingId,status,cancellationReason,cancelledDate).then(res=>{
		console.log(res.data);
		
		
		
		//if updated in db  , move to next page
		
		//window.location.href="index.jsp";
		
			
		
	})
	.catch(err=>{
		console.log(err);
		let data = err.response.data;
		document.querySelector("#message").innerHTML=data.errorMessage;
		console.log(data);
		window.location.href="bookingsummary.jsp";
		
		
		
	});
}
	
	
	
