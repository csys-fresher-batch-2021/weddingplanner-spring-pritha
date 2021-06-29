class BookingService{

static async checkBookingDetails(wdate, wtime, wloc, weddingstyles, weddinglocations, weddingfoodstyles, weddingguestcounts,weddingdecorthemes, status){
		
		let username = JSON.parse(localStorage.getItem("VERIFIED_LOGGED_IN_USER")).userName.toUpperCase();
		console.log(username);
		
		let booking ={"weddingDate" : wdate, "weddingTime" : wtime,
		 "weddingLocation" : wloc, "weddingStyle" : weddingstyles,
		"weddingStyleLocation" : weddinglocations, 
		"weddingFoodStyle" : weddingfoodstyles, 
		"weddingGuestCount" : weddingguestcounts, 
		"weddingDecorTheme" : weddingdecorthemes,
		"username": username,
		"status" : status};
		console.log("Service" + booking);
		
		localStorage.setItem("VERIFIED_BOOKING_DETAILS",JSON.stringify(booking));
		
		
		let url="bookings/checkbookingdetails";//?weddingDate="+wdate+"&weddingTime="+wtime+"&weddingLocation="+wloc+"&weddingStyle="+weddingstyles+"&weddingStyleLocation="+weddinglocations+"&weddingFoodStyle="+weddingfoodstyles+"&weddingGuestCount="+weddingguestcounts+"&weddingDecorTheme="+weddingdecorthemes+"&status="+status+"&username="+username;
		return axios.post(url,booking);
		
	}
	
	static cancelBooking(username,bookingId,status,cancellationReason,cancelledDate){
		let cancelBooking ={
		"username" : username, 
		"bookingId" : bookingId, 
		"status" : status,
		"cancellationReason" : cancellationReason,
		 	"cancelledDate" : cancelledDate};
		console.log("Service" + cancelBooking);
		let url="bookings/cancel/" + bookingId;
		let result = axios.put(url,cancelBooking);
		console.log(result);
		return result;
		
	
	}
	
	static async bookingDetails(){
		let url ="ListAllBookingsServlet";
		return axios.get(url);
	}
	}