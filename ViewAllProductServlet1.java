package Test1;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/ViewProducts")
public class ViewAllProductServlet1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		HttpSession hs= req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		
		else
		{
			ArrayList<ProductBean1> al= new ViewProductsDAO().retrive();
			hs.setAttribute("al", al);
			RequestDispatcher rd= req.getRequestDispatcher("CustomerViewProducts.jsp");
			rd.forward(req, res);
		}
	}
	
}


