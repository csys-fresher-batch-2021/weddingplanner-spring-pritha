class LogoutService{
	
	static logout(userid){
	let url="LogoutServlet?userid="+userid;
	let data = {userId: userid};
	return axios.patch(url,data);
	}
	
}