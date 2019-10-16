<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style type="text/css">
.error
{
color: Red;
}

</style>
</head>
<body>
${msg }

<h1>Register Page</h1>

<form:form action="store" method="post" modelAttribute="bean">
ID:<br/>
<form:input path="id"/><br/>
Name: <br/>
<form:input path="name"/>
<form:errors path="name" cssClass="error"></form:errors><br/>
User Name: <br/>
<form:input path="username"/>
<form:errors path="username" cssClass="error"></form:errors><br/>
Password: <br/>
<form:input path="password" type="password"/>
<form:errors path="password" cssClass="error"></form:errors><br/>
Email: <br/>
<form:input path="email" type="email"/>
<form:errors path="email" cssClass="error"></form:errors><br/>
Mobile:<br/>
<form:input path="mobile"/><br/>
Address:<br/>
<form:textarea path="address"/><br/><br/>
<input type="submit" value="Register">

</form:form>
</body>
</html>