function register(){
	event.preventDefault();
	let userName = document.querySelector("#userName").value;
	let mobileNumber = document.querySelector("#mobileNumber").value;
	let createPassWord = document.querySelector("#createPassWord").value;
	let confirmPassWord = document.querySelector("#confirmPassWord").value;
	
	UserService.register(userName,mobileNumber,createPassWord,confirmPassWord).then(res=>{
		console.log(res.data);
		let data = res.data;
		toastr.success(data.infoMessage);
		//timer set to redirect to page after 5 seconds
		setTimeout(function(){
		window.location.href="login.jsp"
		}, 5000);
	})
	.catch(err=>{
		console.log(err);
		let data = err.response.data;
		toastr.error(data.errorMessage);
		document.querySelector("#message").innerHTML=data.errorMessage;
		console.log(data);
	});
}