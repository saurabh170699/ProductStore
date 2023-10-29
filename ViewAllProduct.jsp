<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin View</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("al");
out.println("welcome :" +ab.getfName()+"<br>");
if(al.size()==0)
{
	 out.println("Product not Available..<br>");
	 
}
else
{
	Iterator<ProductBean> it= al.iterator();
	while(it.hasNext())
	{
		ProductBean pb= (ProductBean)it.next();
		
		 String imagePath ="data:image;base64," +pb.getBase64();
			String altText ="nothing";
			out.println("<img src='"+ imagePath +"' alt='" +altText +"' >");
			
			//<img src = 'data:image;base64,${ib.image}'>
			
		
		
		out.println(pb.getpCode()+"&nbsp&nbsp"+pb.getpName()+"&nbsp&nbsp"+
		pb.getpPrice()+"&nbsp&nbsp"+pb.getpQty()+"&nbsp&nbsp"+
		"<a href ='editProduct?pcode="+pb.getpCode()+"'>Edit</a>"+"&nbsp&nbsp"+
		"<a href ='deleteProduct?pcode="+pb.getpCode()+"'>Delete</a>"+"<br>");
		
	}
}
%>
<a href="Product.html">AddProduct</a>
<a href="Logout">Logout</a> 

</body>
</html>