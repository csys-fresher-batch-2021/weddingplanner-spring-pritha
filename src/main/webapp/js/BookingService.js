class BookingService{
static async checkBookingDetails(wdate, wtime, wloc, weddingstyles, weddinglocations, weddingfoodstyles, weddingguestcounts,weddingdecorthemes){
		let booking ={"weddingDate" : wdate, "weddingTime" : wtime,
		 "weddingLocation" : wloc, "weddingStyle" : weddingstyles,
		"weddingStyleLocation" : weddinglocations, 
		"weddingFoodStyle" : weddingfoodstyles, 
		"weddingGuestCount" : weddingguestcounts, 
		"weddingDecorTheme" : weddingdecorthemes};
		console.log("Service" + booking);
		
		localStorage.setItem("VERIFIED_BOOKING_DETAILS",JSON.stringify(booking));
		
		let url="CheckBookingDetailsServlet"; //?weddingDate="+wdate+"&weddingTime="+wtime+"&weddingLocation="+wloc+"&weddingStyle="+weddingstyles+"&weddingStyleLocation="+weddinglocations+"&weddingFoodStyle="+weddingfoodstyles+"&weddingGuestCount="+weddingguestcounts+"&weddingDecorTheme="+weddingdecorthemes;
		let result = await  axios.post(url,booking);
		console.log(result);
		return result;
	}
	
	static async bookingDetails(){
		let url ="ListAllBookingsServlet";
		return axios.get(url);
	}
	}