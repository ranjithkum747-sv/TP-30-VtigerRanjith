package practiceAS1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadFromSQLTest 
{
	public static void main(String[] args) throws SQLException
	{
		//1. Create the driver object
		Driver driver = new Driver();
		
		//2. Register the Driver
		DriverManager.registerDriver(driver);
		
		//3. Get connection with the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/tp30","root","root");
		
		//4. Create Statements (Create query)
		Statement state = con.createStatement();
		String query="select * from emp;";
		
		//5. Execute the query
		ResultSet res = state.executeQuery(query);
		
		//In order to get the column name
		System.out.println(res.getMetaData()+" ");
		
		
		while(res.next())
		{
			System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3));
		}
		
		//6. Close the connection
		con.close();
		
	}

}
