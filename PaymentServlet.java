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
@WebServlet("/Payment")
public class PaymentServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		Cookie c[] = req.getCookies();
		HttpSession hs =req.getSession(false);
		if(c==null)
		{
			req.setAttribute("msg", "Invalid login proocess..<br>");
			RequestDispatcher rd= req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
			
		}
		else
		{
			String pCode=req.getParameter("code");
			int qty =Integer.parseInt(req.getParameter("reqqty"));
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean1> al= (ArrayList<ProductBean1>)hs.getAttribute("al");
			Iterator<ProductBean1> it=al.iterator();
			while(it.hasNext())
			{
				ProductBean1 pb= (ProductBean1)it.next();
				if(pCode.equals(pb.getpCode()))
				{
					req.setAttribute("pb", pb);
					int q= pb.getpQty();
					pb.setpQty(q-qty);
					
					int k= new UpdateProductDAO1().update(pb);
				
				if(k>0)
				{
					req.setAttribute("msg", "Payment Successfully ...<br>");
					
					//req.getRequestDispatcher("Payment.jsp").forward(req, res);
				   req.getRequestDispatcher("Capcha_Verify.jsp").forward(req, res);
				   break;
				   
				}
			}
			
		}
		
	}

}
}