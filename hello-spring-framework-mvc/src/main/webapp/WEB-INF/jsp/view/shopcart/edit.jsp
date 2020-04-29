<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Create shopcart</h3>
<div id="messages">
	<c:if test="${not empty statusMessageKey}">
		<p>${statusMessageKey}"</p>
	</c:if>

	<spring:hasBindErrors name="shopcartItem">
		<h2>Errors</h2>
		<div class="formerror">
			<ul>
				<c:forEach var="error" items="${errors.allErrors}">
					<li>${error.defaultMessage}</li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>
</div>

<form:form modelAttribute="shopcartItem" action="/shopcarts/add">
	<form:hidden path="article.id" />
	<table>
		<tr>
			<td>Article Name: ${shopcartItem.article.name}</td>
		</tr>
		<tr>
			<td>Article Description: ${shopcartItem.article.description}</td>
		</tr>
		<tr>
			<td>Quantity: <form:input path="quantity" /></td>
		</tr>
	</table>
	<input type="submit" id="save" value="Add" />
</form:form>



<br>
<a href="<c:url value='/'/>">Continue</a>