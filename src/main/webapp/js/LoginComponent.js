function login(){
	event.preventDefault();
	let userName = document.querySelector("#userName").value;
	let passWord = document.querySelector("#passWord").value;
	UserService.login(userName,passWord).then(res=>{
		console.log(res.data);
		let user = res.data;
		//converting object to string 
		localStorage.setItem("VERIFIED_LOGGED_IN_USER",JSON.stringify(user));
		toastr.success("Successfully Logged In");
		//timer set to redirect to page after 3 seconds
		setTimeout(function(){
		window.location.href="weddingstyles.html";
		}, 3000);
		
		
	})
	.catch(err=>{
		console.log(err);
		let data = err.response.data;
		toastr.error(data.errorMessage);
		document.querySelector("#message").innerHTML=data.errorMessage;
		console.log(data);
		
	});
}