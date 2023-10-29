package Test1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

@SuppressWarnings("serial")
@WebServlet("/ViewAllProducts")
public class CustomerViewAllProductsServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		HttpSession hs= req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired..<br>");
			RequestDispatcher rd= req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else
		{
			ArrayList<ProductBean1> al=new ViewProductsDAO().retrive();
			hs.setAttribute("al", al);
			RequestDispatcher rd= req.getRequestDispatcher("CustomerViewProducts.jsp");
			rd.forward(req, res);
		}
	}

}
