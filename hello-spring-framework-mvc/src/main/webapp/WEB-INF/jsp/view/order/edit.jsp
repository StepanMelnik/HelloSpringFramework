<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Create order</h3>
<div id="messages">
	<c:if test="${not empty statusMessageKey}">
		<p>${statusMessageKey}"</p>
	</c:if>

	<spring:hasBindErrors name="customer">
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

<form:form modelAttribute="customer" action="/orders/add">
	<table>
		<tr>
			<td><form:label path="firstname">First Name:</form:label></td>
			<td><form:input path="firstname" /></td>
		</tr>
		<tr>
			<td><form:label path="lastname">Last Name:</form:label></td>
			<td><form:input path="lastname" /></td>
		</tr>
		<tr>
			<td><form:label path="phone">Phone:</form:label></td>
			<td><form:input path="phone" /></td>
		</tr>
		<c:forEach items="${customer.addresses}" var="address" varStatus="i">
			<tr>
				<form:hidden path="addresses[${i.index}].addressType" />
				<td colspan="2" align="right">${address.addressType} Address</td>
			</tr>
			<tr>
				<td><form:label path="addresses[${i.index}].street">Street:</form:label></td>
				<td><form:input path="addresses[${i.index}].street" /></td>
			</tr>
			<tr>
				<td><form:label path="addresses[${i.index}].city">City:</form:label></td>
				<td><form:input path="addresses[${i.index}].city" /></td>
			</tr>
			<tr>
				<td><form:label path="addresses[${i.index}].zip">Zip:</form:label></td>
				<td><form:input path="addresses[${i.index}].zip" /></td>
			</tr>
			<tr>
				<td><form:label path="addresses[${i.index}].state">State:</form:label></td>
				<td><form:input path="addresses[${i.index}].state" /></td>
			</tr>
			<tr>
				<td><form:label path="addresses[${i.index}].country">Country:</form:label></td>
				<td><form:input path="addresses[${i.index}].country" /></td>
			</tr>
	    </c:forEach>		
	</table>
	<input type="submit" id="save" value="Add" />
</form:form>



<br>
<a href="<c:url value='/'/>">Continue</a>