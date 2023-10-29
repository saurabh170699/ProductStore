<%@ page language="java" 
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
AdminBean ab= (AdminBean)session.getAttribute("abean");
out.println("Welcome: "+ab.getfName()+"<br>");
%>

<a href ="Product.html">AddProduct</a>
<a href ="viewProducts">ViewAllProducts</a>
<a href ="Logout">Logout</a>
</body>
</html>