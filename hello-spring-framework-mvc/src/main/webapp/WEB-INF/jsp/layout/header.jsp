<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2><a href="<c:url value="/"/>">Hello Spring MVC</a></h2>

<c:if test="${sessionScope.shopcart != null && sessionScope.shopcart.shopcartItems.size() > 0}">
	<table style="width:270px; float:right; border: 1px solid black">
		<c:forEach items="${shopcart.shopcartItems}" var="shopcartItem">
		<tr>
			<td>${shopcartItem.article.name} (quantity: ${shopcartItem.quantity}; price: ${shopcartItem.article.price}) <a href="<c:url value="/shopcarts/${shopcartItem.article.id}/${shopcartItem.quantity}/remove"/>">X</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="2">Total: ${shopcart.totalAmount}</td>
		</tr>
		<tr>
			<td colspan="2"><a href="<c:url value="/orders/new"/>">Add Order</a></td>
		</tr>
	</table>
</c:if>

<hr>