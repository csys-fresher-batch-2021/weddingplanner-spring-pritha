class UserService{
	static register(userName,mobileNumber,createPassWord,confirmPassWord){
		let user ={
		"userName" : userName, 
		"mobileNumber" : mobileNumber,
		"createPassWord" : createPassWord,
		"confirmPassWord" : confirmPassWord 
		};
		let url="RegisterServlet?userName="+userName+"&mobileNumber="+mobileNumber+"&createPassWord="+createPassWord+"&confirmPassWord="+confirmPassWord;
		return axios.post(url,user);
	}
	static login(userName,passWord){
	let url="LoginServlet?userName="+userName+"&passWord="+passWord;
	return axios.post(url);
	}
	
}