<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello India</h1>
	<form:form action="login.do" method="post" modelAttribute="userMap">
		<pre>
	
		Enter Email    : <form:input path="email" />
			<form:errors path="email" />
		
		Enter password : <form:password path="password" />
			<form:errors path="password" />
						 <input type="submit" value="submit" />
	</pre>
	</form:form>
	<%
		System.out.println(request.getSession().getAttribute("userMsg"));
	%>
	<a href="registration.do">Click Here for Registration!!!!!</a>
	<!-- <a href="product.do">Click Here for Product!!!!!</a> -->
</body>
</html>