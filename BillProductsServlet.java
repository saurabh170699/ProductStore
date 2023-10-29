package Test1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/BillProducts")
public class BillProductsServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException ,IOException
	{
		Cookie c[] =req.getCookies();
		if(c==null)
		{
			req.setAttribute("msg", "Invalid Login Process..<br>");
			RequestDispatcher rd= req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else
		{
			String pcode= req.getParameter("pCode");
			int qty= Integer.parseInt(req.getParameter("ReqQty"));
			
			
			
			HttpSession hs= req.getSession(false);
			String value = c[0].getValue();
			req.setAttribute("fName", value);
			ArrayList<ProductBean1> al=(ArrayList<ProductBean1>)hs.getAttribute("al");
			
			Iterator<ProductBean1> it= al.iterator();
			while(it.hasNext())
			{
				ProductBean1 pb= (ProductBean1)it.next();
				if(pcode.equals(pb.getpCode()))
				{
					req.setAttribute("pb", pb);
					req.setAttribute("qty", qty);
					break;
				}
			}
			
		req.getRequestDispatcher("BillProducts.jsp").forward(req, res);
		}	
	}
}
