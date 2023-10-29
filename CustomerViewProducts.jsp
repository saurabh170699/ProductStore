<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test1.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer view </title>
</head>
<body>
<%

UserBean ab= (UserBean)session.getAttribute("ubean1");
ArrayList<ProductBean1>al = (ArrayList<ProductBean1>)session.getAttribute("al");
out.println("welcome : "+ab.getfName()+"<br>");
if(al.size()==0)
{
	out.println("Product Not Available..<br>");
}
else
{
	Iterator<ProductBean1> it= al.iterator();
	while(it.hasNext())
	{
		ProductBean1 pb= (ProductBean1)it.next();
		
		
		
		 String imagePath ="data:image;base64," +pb.getBase64();
			String altText ="nothing";
			out.println("<img src='"+ imagePath +"' alt='" +altText +"' >");
		
		
		
		
		
	    out.println(pb.getpCode()+"&nbsp&nbsp"+
		pb.getpName()+"&nbsp&nbsp"+
		pb.getpPrice()+"&nbsp&nbsp"+
		pb.getpQty()+"&nbsp&nbsp"+
		"<a href='BuyProduct?pCode="+pb.getpCode()+"'>Buy</a>"+"<br>");
		
		
	}
}
%>
<a href="logingout">Logout</a>
</body>
</html>