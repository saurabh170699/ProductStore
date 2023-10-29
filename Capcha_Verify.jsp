<%@page import="java.nio.charset.Charset"%>
<%@page import="oracle.sql.CharacterSet"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test1.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Caphcha Verify</title>
</head>
<body>
<% 
   UserBean ub = (UserBean)session.getAttribute("ubean1");
   ProductBean1 pb=(ProductBean1)request.getAttribute("pb");
   out.println("Page Belongs To "+ub.getfName()+"<br>"); 
			
	
			
String charset = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*ABCDEFGHIJKLMNOPQRSTUVWXYZ";
StringBuilder captcha =new StringBuilder();
java.util.Random random = new java.util.Random();

for(int i=0; i<6; i++)
{
	char randomChar = charset.charAt(random.nextInt(charset.length()));
	captcha.append(randomChar);
	
	
}
String captchaCode= captcha.toString();

out.print(captchaCode); 

%>
<form action="CompareCaptcha.jsp" method="post">
<input type="hidden" name ="captcha" value=<%=captchaCode %>><br>
Enter a Captcha:<input type="text" name="userInput"/><br>
<input type ="submit" value="Submit"/><br><br>

</form>


			<a href="ViewAllProducts">ViewAllProduts</a>
			<a href="logingout">Logout</a>

</body>
</html>