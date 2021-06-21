<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>booking summary</title>
</head>
<body>
<h3>Booking Summary</h3>
<script>
function displayBookingSummary(){
	var details = JSON.parse(localStorage.getItem("VERIFIED_BOOKING_DETAILS"));
	console.log("Getting the local storage item");
	console.log(details);
	 let content = "";
	
/* content += "<tr>";
		content += "<td>"+details.weddingDate+"</td>";
			content += "<td>" +details.weddingTime +"</td>";
				content += "<td>"+details.weddingLocation+" </td>";
					content += "<td>" +details.weddingStyle.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))+" </td>";
					content += "<td>"+ details. weddingStyleLocation+" </td>";
						content += "<td> "+details.weddingFoodType+"</td>"
						content +="<td>"+details.weddingGuestCount+ "</td>";
							content += "<td>" +details.weddingDecorType+ "</td>"; 
								content += "</tr>";
		
	}
	console.log(content);
	document.querySelector("#booking-tbl").innerHTML= content; 
}); 
 */
}
displayBookingSummary();
</script>
</body>
</html>