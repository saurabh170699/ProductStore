package Test1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		UserBean ub =new  UserBean();
		ub.setuName(req.getParameter("uName"));
		ub.setpWord(req.getParameter("pWord"));
		ub.setfName(req.getParameter("fName"));
		ub.setlName(req.getParameter("lName"));
		ub.setAddr(req.getParameter("Addr"));
		ub.setmId(req.getParameter("mId"));
		ub.setPhNo(Long.parseLong(req.getParameter("PhNo")));
		int k= new RegisterDAO().register(ub);
		if(k>0)
		{
			req.setAttribute("msg", "Registration Process Successfull..<br>");
			RequestDispatcher rd= req.getRequestDispatcher("RegSuccess.jsp");
			rd.forward(req, res);
		}
		
	}

}
