<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="addData">
	<input type="text" name="mid"/>
	<input type="text" name="mname"/>
	<input type="text" name="mlang"/>
	<input type="submit"/>
	</form>
	
	<form action="showData">
	<input type="text" name="mlang"/>
	<input type="submit" value="show"/>
	</form>
</body>
</html>