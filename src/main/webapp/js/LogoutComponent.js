function logout(){
	event.preventDefault();
	let userId = document.querySelector("#userid").value;
	LogoutService.logout(userId).then(res=>{
		console.log(res.data);
	   let user = res.data;
		if(user==true){
		window.location.href="weddingstyles.html";
		}
		
	})
	.catch(err=>{
		console.log(err);
		let data = err.response.data;
		document.querySelector("#errorMessage").innerHTML=data.errorMessage;
		console.log(data);
		
	});
}