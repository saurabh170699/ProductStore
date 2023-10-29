package Test1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import test.AdminBean;
import test.DBConnection;

public class ViewProductsDAO {
	public ArrayList<ProductBean1> al = new ArrayList<ProductBean1>();
	public ArrayList<ProductBean1>retrive()
	 
	{
		try
		{
			Connection con= DBConnection.getCon();
			PreparedStatement ps= con.prepareStatement("select * from Product55");
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				ProductBean1 pb= new ProductBean1();
				pb.setpCode(rs.getString(1));
				pb.setpName(rs.getString(2));
				pb.setpPrice(rs.getFloat(3));
				pb.setpQty(rs.getInt(4));
				
				InputStream inputStream= rs.getBinaryStream(5);
				  ByteArrayOutputStream	 outputStream = new ByteArrayOutputStream();
				 
				  byte[] img =new byte[4096];
				  
				  int bytesRead = -1; 
				  while((bytesRead =  inputStream.read(img)) != -1) 
				  {
					  outputStream.write(img, 0, bytesRead);
				  
				  }
				  
				  byte[] imageBytes = outputStream.toByteArray();
				  String imgBase64 = Base64.getEncoder().encodeToString(imageBytes);
				  
			      pb.setBase64(imgBase64);
				  Base64.getEncoder().encodeToString(imageBytes); pb.setBase64(imgBase64);
				 
				
				
				
				
				
				
				  
				al.add(pb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
		}
}
