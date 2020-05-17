<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Async call to fetch all customers</h3>
<br> 

<table>
	<c:forEach items="${customers}" var="customer">
	<tr>
		<td>Customer: ${customer.firstname} ${customer.lastname}</td>
	</tr>
	</c:forEach>
</table>