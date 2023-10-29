<%@page import="Test1.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>captcha Wrong captcha</title>
</head>
<body>
<%
  UserBean ub = (UserBean)session.getAttribute("ubean1");
			out.println("Page Belongs to "+ub.getfName()+"<br>");
  


		    String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghighijklmnopqrstuvwxyz";
        StringBuilder captcha = new StringBuilder();
        java.util.Random random = new java.util.Random();
        
        for (int i = 0; i < 6; i++) { 
            char randomChar = charset.charAt(random.nextInt(charset.length()));
            captcha.append(randomChar);
        }
        String captchaCode = captcha.toString();
        
       out.print(captchaCode); 
       
%>
    <br><br>

   <form action ="CompareCaptcha.jsp" method = "post">
   Enter a Captcha: <input type ="text" name="userInput"/>
   <input type="hidden" name="captcha" value =<%=captchaCode %>><br>
   <input type="submit" value="Submit"/><br><br> 
   
   
   </form>
   

            <a href="logingout">Logout</a>
  
			<a href="ViewAllProducts">ViewAllProduts</a>


</body>
</html>