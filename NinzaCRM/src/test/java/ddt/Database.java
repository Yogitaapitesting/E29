package ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Database {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/mysql", "root", "root");
		Statement stat = con.createStatement();
		ResultSet re = stat.executeQuery("select * from demo1");
		while(re.next())
		{
			System.out.println(re.getString(1));
		}
		

	}

}
