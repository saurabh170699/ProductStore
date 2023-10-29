package Test1;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/clogin")
public class CustomerLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException , IOException
	{
		UserBean ab= new CustomerLoginDAO().login(req);
		if(ab==null)
		{
			req.setAttribute("msg", "Invalide login process..<br>");
			RequestDispatcher rd= req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else
		{
			HttpSession hs= req.getSession();
		    hs.setAttribute("ubean1", ab);
		    RequestDispatcher rd= req.getRequestDispatcher("CustomerLogSuccess.jsp");
		    rd.forward(req, res);
		}   
		
	}

}
