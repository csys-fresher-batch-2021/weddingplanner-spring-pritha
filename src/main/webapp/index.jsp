<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="/js/routes.js"></script>
</head>
<body>
    <h3>HomePage</h3>

    <ul>
        <li><a href="register.jsp" onclick="navigate('register.jsp')">REGISTER(GUEST) </a></li>
        <li><a href="login.jsp" onclick="navigate('login.jsp')">LOGIN (ADMIN,USER) </a></li>
        <li><a href="booking.jsp" onclick="navigate('booking.jsp')">BOOKING (USER, ADMIN) </a></li>
    	<li><a href="bookingsummary.jsp" onclick="navigate('bookingsummary.jsp')">BOOKING SUMMARY (ADMIN) </a></li>
   		<li><a href="logout.jsp" onclick="navigate('logout.jsp')">LOGOUT(USER,ADMIN)</a></li>
    </ul>


    
    
<script>
function checkPermissions(pageName){
    let userRole = JSON.parse(localStorage.getItem("VERIFIED_LOGGED_IN_USER")).role;
    console.log("User Logged role:" + userRole);
    let allowed = false;
    for(let route of routes){
    if(route.path == pageName) {
        let roles = route.roles;
        if (roles.length ==0){
            allowed = true;
            break;
        }
        else if(roles.includes(userRole)){
        	allowed = true;
         	break;
      }
    }
    }
    return allowed;
}

function navigate(pageName){
    event.preventDefault();
    let allowed = checkPermissions(pageName);
    console.log(allowed);
    if (allowed){
        alert("Redirecting ...");
        window.location.href=pageName;
    }
    else{
        alert("You are not authorized");
    }
 	return false;
}

 </script>
</body>
</html>