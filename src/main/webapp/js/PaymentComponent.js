
	
	let username = JSON.parse(localStorage.getItem("VERIFIED_LOGGED_IN_USER")).userName;
		console.log(username);
		let params = new URLSearchParams(location.search.substr(1));
		let bookingId = parseInt(params.get('bookingId')); //global scope
		let params2 = new URLSearchParams(location.search.substr(2));
		let fare = parseInt(params2.get('fare'));
		//alert(fare);
		//document.getElementById("amounts").innerHTML= fare;
		 //document.getElementById("amounts").setAttribute('value',fare);
		//document.getElementById('fares').value=fare;
		//document.getElementById("fares").value= 99880;
	
		
		
		async function checkPaymentDetails(){
		
		event.preventDefault();
		
		console.log(bookingId);
		let bank = $('input[name=bank_status]:checked').val();
		let card = $("#card").val();
		let cardUserName = $("#cardusername").val();
		let cardNo = $("#ccn").val();
		let expiryDate =  $("#expirydate").val();
		let cvv =  $("#cvv").val();
		let amount =  fare;
		let purpose =  $("#purpose").val();
		await PaymentService.checkPaymentDetails(bank,card,cardUserName,cardNo,expiryDate,cvv,amount,purpose).then(res=>{
		console.log(res.data);
		let success = res.data;
		if(success==true){
			window.location.href="final.html";
			
		}
		
		
			
		
	})
	.catch(err=>{
		console.log(err);
		let data = err.response.data;
		document.querySelector("#message").innerHTML=data.errorMessage;
		console.log(data);
		window.location.href="onlinepayment.jsp";
		
		
		
	});
}


function reduceAmount(){
	alert("reduceAmount");
	var amount = parseInt(document.getElementById("amount").value);
	console.log(amount);
	var rupees = document.getElementById("rupees").innerText;
    console.log(rupees);
	var amountAfterEarnedCoinsApply = amount - rupees;
	console.log(amountAfterEarnedCoinsApply);
	//document.getElementById("amount").innerHTML = amountAfterEarnedCoinsApply;
	alert("Discount applied Successfully");
	let cartItemStr = localStorage.getItem("ITEMS_ADDED");
	const cartItems = cartItemStr == null ? [] : JSON.parse(cartItemStr);
	let item = { bookingId : bookingId, earnedCoins : rupees , amount : amountAfterEarnedCoinsApply};
	cartItems.push(item);
	localStorage.setItem("ITEMS_ADDED",JSON.stringify(cartItems));
	loadMyEarnedCoins();
	window.location.href="Invoice.html";
	
}

	function retriveAmount(){
	alert("GoingToREmove");
	localStorage.removeItem("ITEMS_ADDED");
	var amount = parseInt(document.getElementById("amount").value);
	document.getElementById("amount").value = amount;
	loadMyEarnedCoins();
	window.location.href="Invoice.html";
	
}


		
	
