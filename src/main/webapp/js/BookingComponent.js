async function checkBookingDetails(){
	event.preventDefault();
	let weddingDate = document.querySelector("#wdate").value;
	let weddingTime = document.querySelector("#wtime").value;
	let weddingLocation = document.querySelector("#wloc").value;
	let weddingStyle = document.querySelector("#weddingstyles").value;
	let weddingStyleLocation = document.querySelector("#weddinglocations").value;
	let weddingFoodStyle = document.querySelector("#weddingfoodstyles").value;
	let weddingGuestCount = document.querySelector("#weddingguestcounts").value;
	let weddingDecorTheme = document.querySelector("#weddingdecorthemes").value;
	console.log(weddingDate,weddingTime,weddingLocation);
	
	
	await BookingService.checkBookingDetails(weddingDate,weddingTime,weddingLocation,weddingStyle,weddingStyleLocation,
	weddingFoodStyle,weddingGuestCount,weddingDecorTheme).then(res=>{
		console.log(res.data);
		let bookingDetails = res.data;
		//if validate , move to summary page
		
		window.location.href="bookingsummary.jsp";
		
			
		
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