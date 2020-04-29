<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

Order created successfully for Customer: ${customer.firstname} ${customer.lastname} 
<br> 

<table>
	<c:forEach items="${customer.orders}" var="order">
	<tr>
		<td>Created: ${order.orderDate}</td>
	</tr>
	<tr>
		<td>Total Amount: ${order.totalAmount}</td>
	</tr>
	</c:forEach>
</table>

<br>
<a href="<c:url value='/'/>">Continue</a>