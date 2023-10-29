package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		AdminBean ab = new AdminLoginDAO().login(req);
		if(ab==null)
		{
			req.setAttribute("msg", "Invalid Login Process <br>");
			RequestDispatcher rd= req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
			
		}
		else
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("abean", ab);
			RequestDispatcher rd = req.getRequestDispatcher("LogSuccess.jsp");
			rd.forward(req, res);
		}
	}

}
