<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body topmargin="2">
	<h1>Hello new Registration</h1>
	<form:form action="userregistration.do" method="post"
		modelAttribute="registrationMap">
		
		<pre>
		
		Language :		 <a href="?language=en">English</a>|<a href="?language=hi">Hindi</a>|<a href="?language=cn">Chinese</a>
		<table border="3" align="center" cellpadding="2" cellspacing="2" background="pink" >
		<tr>
			<td><spring:message code="label.em"/> 			: <form:input path="email" /></td>	
								  					  		<form:errors path="email" />
		</tr>
		<tr>
			<td><spring:message code="label.pwd"/> 			: <form:password path="password" /></td>
							  					  			<form:errors path="password" />
		</tr>
		<tr>					  					  		
			<td><spring:message code="label.fn"/>			: <form:input path="firstname" /></td>
							  					  			<form:errors path="firstname" />
		</tr>
		<tr>					  					  		
			<td><spring:message code="label.ln"/>  			: <form:input path="lastname" /></td>
							  						  		<form:errors path="lastname" />
		</tr>
		<tr>					  					  		
			<td><spring:message code="label.mo"/> 			: <form:input path="mobileno" /></td>
							  						  		<form:errors path="mobileno" />
		</tr>					  					  		
					<tr><td> <input type="submit" value="<spring:message code="label.sb"/>" /></td></tr>
		</pre>											 
						 
<%-- <%		System.out.println(request.getAttribute("email")); 
		System.out.println(request.getAttribute("password")); 
		System.out.println(request.getAttribute("firstname")); 
		System.out.println(request.getAttribute("lastname")); 
		System.out.println(request.getAttribute("mobileno")); 
%> --%>
	
	</table>
	</form:form>
</body>
</html>