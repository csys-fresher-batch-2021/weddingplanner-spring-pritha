function logout(){
	event.preventDefault();
	let userId = document.querySelector("#userid").value;
	LogoutService.login(userId).then(res=>{
		console.log(res.data);
		window.location.href="weddingstyles.html";
		
	})
	.catch(err=>{
		console.log(err);
		let data = err.response.data;
		document.querySelector("#message").innerHTML=data.errorMessage;
		console.log(data);
		
	});
}