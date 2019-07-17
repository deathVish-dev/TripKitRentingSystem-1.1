<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="ft"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Page</h1>
<input type="text" value="${msg}" >
<ft:form method="post" modelAttribute="login">
Username: <ft:input path="uname"/>
Password: <ft:input path="pass"/>
<ft:button value="Submit" name="Submit">Submit</ft:button>
</ft:form>
</body>
</html>