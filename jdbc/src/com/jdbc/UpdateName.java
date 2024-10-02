package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateName {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
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
  String query="update student set name=?, age =? where id= ?";
  PreparedStatement ps=conn.prepareStatement(query);
  System.out.println("Enter the name to update:");
  ps.setString(1, sc.nextLine());
 // sc.nextLine();
  System.out.println("Enter for whom to update:");
  ps.setInt(2, sc.nextInt());
  ps.setInt(3, sc.nextInt());
  ps.executeUpdate();
  conn.close();
	}

}
