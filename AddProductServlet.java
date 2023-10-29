package test;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@SuppressWarnings("serial")
@WebServlet("/addProduct")
@MultipartConfig(fileSizeThreshold = 1024*1024,
maxFileSize = 1024*1024*5,
maxRequestSize = 1024*1024*10)
public class AddProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req , HttpServletResponse res)
	throws ServletException,IOException {
		HttpSession hs= req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired..<br>");
			RequestDispatcher rd= req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
			
		}
		else
		{
		   ProductBean pb =new ProductBean();
		   
		   pb.setpCode(req.getParameter("code"));
		   pb.setpName(req.getParameter("name"));
		   pb.setpPrice(Float.parseFloat(req.getParameter("price")));
		   pb.setpQty(Integer.parseInt(req.getParameter("qty")));
		   
		   
			InputStream is=null;
			Part part=req.getPart("photo");
			if(part!=null)
			{    
				is=part.getInputStream();
			}
				if(is!=null)
			{
				pb.setIs(is);
			}
		   
		   
		   int k= new AddProductDAO().insert(pb);
		   if(k>0)
		   {
			   req.setAttribute("msg", "Product Added Succfully..<br>");
			   RequestDispatcher rd =req.getRequestDispatcher("AddProduct.jsp");
			   rd.forward(req, res);
		   }
			}
		   
		  
				
	}
	

}
