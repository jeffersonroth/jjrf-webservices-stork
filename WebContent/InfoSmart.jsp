<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Info Smart</title>
</head>
<body>
    <%
        response.setStatus(301);
        response.setHeader("Location", "/InfoSmart.html");
        response.setHeader("Connection", "close");
    %>
</body>
</html>