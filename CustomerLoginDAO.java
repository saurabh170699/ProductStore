package Test1;

import java.sql.*;
import javax.servlet.http.*;
import test.*;

public class CustomerLoginDAO 
{
	public UserBean ab = null;
	public UserBean login(HttpServletRequest req)
	{
		try
		{
			Connection con =DBConnection.getCon();
			PreparedStatement ps =con.prepareStatement("select * from CustomerTab55 where uName=? and pWord=?");
			ps.setString(1, req.getParameter("uName"));
			ps.setString(2, req.getParameter("pWord"));
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
			ab=new UserBean();
			ab.setuName(rs.getString(1));
			ab.setpWord(rs.getString(2));
			ab.setfName(rs.getString(3));
			ab.setlName(rs.getString(4));
			ab.setAddr(rs.getString(5));
			ab.setmId(rs.getString(6));
			ab.setPhNo(rs.getLong(7));
			
			}
			
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ab;
	}


}
