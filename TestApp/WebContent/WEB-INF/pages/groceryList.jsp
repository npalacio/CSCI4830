<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!--taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grocery List</title>
<style type="text/css">
    .container {
        width: 100px;
        clear: both;
        margin: auto;
    }
    .container input {
        width: 100%;
        clear: both;
    }

    </style>
</head>
<body>
<h1 style="text-align: center">Grocery List</h1>
<table align="center">
	<tr>
		<td>Item</td>
		<td>Price</td>
	</tr>
	<c:forEach var="item" items="${groceryItems}">
		<tr>
			<td>${item.item}</td>
			<td>$<fmt:formatNumber type="number" 
            minIntegerDigits="1" value="${item.price}" minFractionDigits="2" maxFractionDigits="2"/></td>
			<td><a href="${pageContext.request.contextPath}/AddRemove?name=${item.item}">Remove Item</a></td>
		</tr>
	</c:forEach>
</table>
<br/>
<div class="container" align="center">
<form method="post" action="${pageContext.request.contextPath}/AddRemove">
	<p>Item:</p>
	<input type="text" name="name"/>
	<p>Price:</p>
	<input type="text" name="price"/>
	<input type="submit" value="Add"/>
</form>
</div>
</body>
</html>