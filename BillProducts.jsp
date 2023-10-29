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
//String fName=(String)request.getAttribute("fName");
UserBean ab =(UserBean)session.getAttribute("ubean1");
out.println("Page Belongs to "+ab.getfName()+"<br>");

int qty =(int)request.getAttribute("qty");
ProductBean1 pb= (ProductBean1)request.getAttribute("pb");
//pb.setpQty(pb.getpQty()-qty);
float Payment =pb.getpPrice()*qty;

%>
<form action ="Payment" method="post"> 
Code :<input type="text" name="code" value=<%=pb.getpCode()%>><br>
Name :<input type="text" name="name" value=<%=pb.getpName()%>><br>
ReqQty :<input type="text" name="reqqty" value=<%=qty%>><br>
TotalAmount:<input type="text" name="totalpayment" value=<%=Payment%>><br>
<input type="submit" value="Payment">

</form>

</body>
</html>