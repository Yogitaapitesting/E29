package ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class BD {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
    Driver driverref=new Driver();
    DriverManager.registerDriver(driverref);
  Connection con = DriverManager.getConnection
		  ("jdbc:mysql://localhost:3306/mysql", "root", "root");
   Statement sta = con.createStatement();
   ResultSet r = sta.executeQuery("selct * from demo1");
   while(r.next()) {
	   System.out.println(r.getString(1));
   }
	}

}
