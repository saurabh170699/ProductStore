package test;

import static test.DBInfo.*;
import java.sql.*;

public class DBConnection {
private static Connection con;
private DBConnection()
{
}
static 
{
	try 
	{
		Class.forName(driver);
		con= DriverManager.getConnection(dbURL, uName, pWord);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	public static Connection getCon()
	{
		return con;
		
	}


}
