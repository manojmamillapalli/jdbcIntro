package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
public class getConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// establish the connection
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		String password="Manoj@123";
		Connection conn=DriverManager.getConnection(url, user, password);
        if(conn!=null)
        {
        	System.out.println("Connected");
        }
       
	}

}
