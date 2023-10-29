package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO 
{
	public int k=0;
	public int update(ProductBean pb)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update Product55 set price=?,qty=? where code=?");
			ps.setFloat(1, pb.getpPrice());
			ps.setInt(2, pb.getpQty());
			ps.setString(3, pb.getpCode());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();;
		}
		
		return k;
		
	}

}
