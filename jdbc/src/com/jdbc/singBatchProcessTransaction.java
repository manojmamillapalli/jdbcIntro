package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class singBatchProcessTransaction {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/advjava";
		String user="root";
		String pass="Manoj@123";
		Connection conn=DriverManager.getConnection(url,user, pass);
		conn.setAutoCommit(false);
		String query="insert into faculty values(?,?,?)";
		PreparedStatement ps=conn.prepareStatement(query);
		while(true)
		{
			System.out.println("Enter name : name");
			ps.setString(1, sc.nextLine());
			System.out.println("Enter ID : id");
			ps.setInt(2, sc.nextInt());
			sc.nextLine();
			System.out.println("Enter dept : Dept");
			ps.setString(3, sc.nextLine());
			System.out.println("Do you want to enter another record? Y/N");
			String s=sc.nextLine();
			ps.addBatch();
			if(s.equals("N"))
			{
				break;
			}
			
		}
		ps.executeBatch();
		
		System.out.println("Commit : C, RollBack : R");
		String s=sc.next();
		if(s.equals("R"))
		{
			conn.rollback();
		}
		else if(s.equals("C"))
		{
			conn.commit();
		}
		conn.close();

	}

}
