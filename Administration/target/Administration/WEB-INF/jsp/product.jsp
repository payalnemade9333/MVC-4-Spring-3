<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.jqueryui.min.css" />
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>Product !!!!</h1>
	<a href="logout.do">Logout</a>
	<form:form action="product.do" method="post"
		modelAttribute="productMap">
		<pre>
		
		Enter Product Id    			:   <form:input path="pid" />
											<form:errors path="pid" />
		Enter Product Name 				:   <form:input path="productname" />	
											<form:errors path="productname" />
		Enter Price						:   <form:input path="price" />		    
											<form:errors path="price" />
		Enter Quantity 					:   <form:input path="quantity" />	    
											<form:errors path="quantity" />
		Enter Product Desciption 		:   <form:input path="productdesc" />	
											<form:errors path="productdesc" />
						   <input type="submit" value="submit" />
						 
<%--  <%
						  		System.out.println(request.getAttribute("productname"));
						  		System.out.println(request.getAttribute("price"));
						  		System.out.println(request.getAttribute("quantity"));
						  		System.out.println(request.getAttribute("productdesc"));
%>	 --%>	
	</pre>
	</form:form>
	<hr>
	<table id="example" class="display" border="2" align="center">
		<thead>
			<tr>
				<td><B>Product ID </td>
				<td><B>Product Name </td>
				<td><B>Product price </td>
				<td><B>Product quantity </td>
				<td><B>Product description </td>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${prod}" var="prodlist">
				<tr>
					<td><c:out value="${prodlist.pid}" /></td>
					<td><c:out value="${prodlist.productname}" /></td>
					<td><c:out value="${prodlist.price}" /></td>
					<td><c:out value="${prodlist.quantity}" /></td>
					<td><c:out value="${prodlist.productdesc}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td><B>Product ID </td>
				<td><B>Product Name </td>
				<td><B>Product price </td>
				<td><B>Product quantity </td>
				<td><B>Product description </td>
			</tr>
		</tfoot>
	</table>
</body>
</html>