package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

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
		        //get the statement object
//		        Statement st=conn.createStatement();
		        //pass sql query to the db
		        //st.executeUpdate("create table Employee(id int(3),name varchar(50),salary int(6))");
		        String query="create table student(id int, name varchar(60), age int)";
		        PreparedStatement ps=conn.prepareStatement(query);
		        ps.executeUpdate();

	}

}
