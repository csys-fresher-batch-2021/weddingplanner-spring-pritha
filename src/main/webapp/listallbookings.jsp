<%@page import="java.util.List"%>
<%@page import="in.pritha.model.BookingEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
     <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All Bookings</title>
</head>
<body>
<h3>Booking Details </h3>

	<c:if test="${empty BOOKING_DETAILS}">
		No record exists!
		</c:if> 
		<c:if test="${not empty BOOKING_DETAILS}">
		<table border="1">
		<thead>
		<tr>
		<th>S.No</th><th>Booking Id </th><th> Booked By </th><th> Booking Status </th><th> Booked Date </th></tr>
		</thead>
		<tbody id="booking-body">
		<c:forEach items="${BOOKING_DETAILS}" var="booking" varStatus="Loop">
		<tr>
		<td> ${loop.index+1}</td>
		<td> ${booking.bookingId}</td>
		<td> ${booking.bookedBy.userName}</td>
		<td> ${booking.bookingStatus}</td>
		<td>
		<fmt:parseDate value="${booking.bookedDate}" pattern="yyyy-MM-dd" var="bookedDate" type="date" />

<fmt:formatDate value="${bookedDate}" var="bookedDate" type="date" pattern="dd.MM.yyyy" />
		 ${bookedDate}</td>
		 </tr>
		 </c:forEach>
		</tbody>
		</table>
		</c:if>







</body>
</html>