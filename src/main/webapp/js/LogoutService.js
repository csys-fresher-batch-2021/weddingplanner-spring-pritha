class LogoutService{
	
	static logout(userid){
	let url="LogoutServlet?userid="+userid;
	return axios.post(url);
	}
	
}