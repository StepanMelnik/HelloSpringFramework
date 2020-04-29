<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Select article to add one into shopcart</h3>
<br> 

<table>
	<c:forEach items="${articles}" var="article">
	<tr>
		<td><a href="<c:url value="/shopcarts/${article.id}/new"/>">${article.name}</a></td>
		<td>${article.description}</td>
	</tr>
	</c:forEach>
</table>