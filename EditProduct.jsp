<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
ProductBean pb= (ProductBean)request.getAttribute("pb");
out.println("Page belongs to "+ab.getfName()+"<br>");
%>
<form action="updateProduct" method="post">
<input type="hidden" name="code" value=<%=pb.getpCode()
%>>
ProductPrice:<input type="text" name="price"
value=<%=pb.getpPrice() %>><br>
ProductQty:<input type="text" name="qty"
value =<%=pb.getpQty() %>><br>
<input type="submit" value ="UpdateProduct">
</form>
</body>
</html>