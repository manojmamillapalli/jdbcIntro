package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.*;
public class InsertWithPreparedStatement {

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
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name:");
        String name=sc.nextLine();
        
        System.out.println("Enter age:");
        int age=sc.nextInt();
        
        String query="insert into student values(?,?,?)";
        PreparedStatement ps=conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        ps.executeUpdate();
        conn.close();
        
        

	}

}
