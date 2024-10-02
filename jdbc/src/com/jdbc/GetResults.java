package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetResults {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
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
        String query="select * from student";
        PreparedStatement ps=conn.prepareStatement(query);
        ResultSet rs=ps.executeQuery(); 
        while(rs.next()) {
        	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+ rs.getInt(3));
        }
        //ps.executeUpdate();

	}

}
