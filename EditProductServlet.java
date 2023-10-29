package test;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@SuppressWarnings("serial")
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet
{
   @SuppressWarnings("unchecked")
   protected void doGet(HttpServletRequest req , HttpServletResponse res)
   throws ServletException , IOException
   {
	   HttpSession hs= req.getSession(false);
	   if(hs==null)
	   {
		   req.setAttribute("msg", "Session expired ..<br>");
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
				   req.setAttribute("pb", pb);
				   break;
				   
			   }
			   
			   
		   }
		   req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
	   }
   }
}
