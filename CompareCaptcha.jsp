<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "Test1.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Captcha comparison</title>
</head>
<body>

<% 
    UserBean ub= (UserBean)application.getAttribute("ubean1");
    String userInput = request.getParameter("userInput");
    String captcha= request.getParameter("captcha");
    
    if(userInput!=null && userInput.equals(captcha))
    {
    	request.setAttribute("msg", "Order done successfully... ");
    	RequestDispatcher dispatcher= request.getRequestDispatcher("Payment.jsp");
    	dispatcher.forward(request, response);
    }	    	
    else
    {
    	request.setAttribute("msg", "Captcha Code is Not Matched..");
    	RequestDispatcher dispatcher = request.getRequestDispatcher("Captcha_Wrong.jsp");
    	dispatcher.forward(request, response);
    	
    }
%>
    
     
</body>
</html>