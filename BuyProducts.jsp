<%@page import="test.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test1.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Product</title>
</head>
<body>
<%

UserBean ab =(UserBean)session.getAttribute("ubean1");
out.println("Page Belongs To "+ab.getfName()+"<br>");
ProductBean1 pb =(ProductBean1)request.getAttribute("pb");
%>
<form action ="BillProducts" method= "post">
code :<input type="text" name="pCode" value=<%=pb.getpCode()%>><br>
Name :<input type="text" name="pName" value=<%=pb.getpName()%>><br>
Price :<input type="text" name="pPrice" value=<%=pb.getpPrice()%>><br>
Qty :<input type="text" name="pQty" value=<%=pb.getpQty()%>><br>
ReqQty:<input type="text" name="ReqQty"><br>
<input type="submit" value="BuyProduct">

</form>
</body>
</html>