package Test1;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.DBConnection;

public class UpdateProductDAO1 {
 public int k=0;
 public int update(ProductBean1 pb)
 {
	 try
	 {
		 Connection con=DBConnection.getCon();
		 PreparedStatement ps= con.prepareStatement("update Product55 set qty=? where code=?");
		 
		 ps.setInt(1, pb.getpQty());
		 ps.setString(2, pb.getpCode());
		 System.out.println(pb.getpQty());
		 k=ps.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 
	return k;
	 
 }
}
