<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
var total=0;
$(document).ready(function(){
	$("#count").val(total);
  $("#sub").click(function(){
    $("#count").val(--total);
  });
  $("#add").click(function(){
	    $("#count").val(total++);
	  });
});
</script>
</head>
<body>
<form method="get" action="cart">
<h1>${product.id}<br>${product.name}<br>${product.description}</h1>
<input type="button" id="sub" value="-">
<input type="text" id="count" name="count">
<input type="button" id="add" value="+">
<br> 
<input type="hidden" name="pid" value="${product.id}">
<br>
<input type="submit" value="Add To Cart">
</form>
</body>
</html>