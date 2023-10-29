package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet
{
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException ,IOException
	{
		HttpSession hs= req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			String pCode =req.getParameter("pcode");
			ArrayList<ProductBean> al= (ArrayList<ProductBean>)hs.getAttribute("al");
			Iterator<ProductBean> it= al.iterator();
			while(it.hasNext())
			{
				ProductBean pb= (ProductBean)it.next();
				if(pCode.equals(pb.getpCode()))
				{
					it.remove();
					break;
				}
			}
			int k= new DeleteProductDAO().Delete(pCode);
			if(k>0)
			{
				req.setAttribute("msg", "Product Deleted Succesfully..<br>");
			}
			req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
		}
	}
	

}
