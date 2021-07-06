class PaymentService{
	
	 static async checkPaymentDetails(bank,card,cardUserName,cardNo,expiryDate,cvv,amount,purpose){
		
		
		
		let payment ={
		"selectedBank" : bank,
		"cardType" : card,
		"cardUserName" : cardUserName,
		"cardNo" : cardNo,
		"expiryDate" : expiryDate,
		"cvv" : cvv,
		"amount" : amount,
		"purpose" : purpose};
		console.log("Service" + payment);
		
		
		
		let url="payments/returnpaymentdetails";
		return axios.post(url,payment);
		
	}
}