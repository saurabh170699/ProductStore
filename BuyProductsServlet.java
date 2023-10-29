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

import test.AdminBean;

@SuppressWarnings("serial")
@WebServlet("/BuyProduct")
public class BuyProductsServlet extends HttpServlet
{
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		Cookie c[] =req.getCookies();
		
		if(c==null)
		{
			req.setAttribute("msg", "Session Expired..<br>");
		RequestDispatcher rd= req.getRequestDispatcher("CustomerViewProducts.jsp");
				rd.forward(req, res);
    	}
	
	    else
	    {
	    	String pCode=req.getParameter("pCode");
	    	HttpSession hs=req.getSession(false);
	    	String value=c[0].getValue();
	    	UserBean ub=(UserBean) hs.getAttribute("ubean1");
	    	req.setAttribute("fName", ub.getfName());
	    	ArrayList<ProductBean1> al=(ArrayList<ProductBean1>)hs.getAttribute("al");
	    	Iterator<ProductBean1> it=al.iterator();
	    	while(it.hasNext())
	    	{
	    		ProductBean1 pb= (ProductBean1)it.next();
	    		if(pCode.equals(pb.getpCode()))
	    		{
	    			req.setAttribute("pb", pb);
	    			break;
	    		}
	    		
	    		
	    	}
	    	req.getRequestDispatcher("BuyProducts.jsp").forward(req, res);
	    }
	}
}
