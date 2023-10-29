<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test1.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
UserBean ab=(UserBean)session.getAttribute("ubean1");
out.println("Welcome :"+ab.getfName()+"<br>");

%>

<a href ="ViewProducts">ViewAllProducts</a>
<a href ="logingout">Logout</a>

</body>
</html>