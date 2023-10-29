package test;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet
{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session expired <br>");
			
		}
		else
		{
		  hs.removeAttribute("abean");
		  hs.removeAttribute("al");
		  hs.invalidate();
		  req.setAttribute("msg", "LoggoutSuccsfully <br>");
		}
		req.getRequestDispatcher("Home.jsp").forward(req, res);
	}
	
	

}
