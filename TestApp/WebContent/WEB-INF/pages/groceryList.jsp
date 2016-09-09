<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grocery List</title>
</head>
<body>
<table>
	<tr>
		<td>Item</td>
		<td>Price</td>
	</tr>
	<c:forEach var="item" items="${groceryItems}">
		<tr>
			<td>${item.item}</td>
			<td>${item.price}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>