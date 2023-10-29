<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test1.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
UserBean ab=(UserBean)session.getAttribute("ubean1");
ArrayList<ProductBean1>al=(ArrayList<ProductBean1>)session.getAttribute("al");
out.println("Page Belong to "+ab.getfName()+"<br>");
if(al.size()==0)
{
	out.println("Paymnet fail..<br>");
}
else
{
	out.println("Payment Successfully");
		
}
%>
<a href ="ViewAllProducts">ViewAllProducts</a>
<a href ="logingout">Logout</a>

</body>
</html>