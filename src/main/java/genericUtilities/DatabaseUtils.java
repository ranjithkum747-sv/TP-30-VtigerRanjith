package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtils
{
	Connection conn=null;
	
	public void connectToDB() throws SQLException
	{
		//register the driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		//get the connection
		conn=DriverManager.getConnection(IpathConstants.dburl,IpathConstants.dbUserName, IpathConstants.dbPassword);

	}

	public ResultSet executeQuery(String query) throws SQLException
	{
		//Create Statement
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery(query);
		return result;
	}

	public int updateQuery(String query) throws SQLException
	{
		//Create Statement
		Statement state = conn.createStatement();
		int res = state.executeUpdate(query);
		return res;
	}
	
	public void disconnectDB() throws SQLException
	{
		conn.close();
	}
}
