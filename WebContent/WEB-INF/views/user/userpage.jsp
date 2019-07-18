<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("h1").click(function(){
    $("h3").toggle();
  });
});
</script>
</head>
<body>
<h1>Customer Page</h1>
<h3>Welcome ${sessionScope.loginuser.uname}</h3>
<div align="center">
<table>
<c:forEach items="${productlist}" var="product" >
<tr>
<td><img src="resources/images/dslr.jpg" alt="Photo"></td>
<td><a href="product?id=${product.id}"><br>${product.name}<br>${product.description}</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>