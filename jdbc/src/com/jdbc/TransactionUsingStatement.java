package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class TransactionUsingStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/advjava";
		String user="root";
		String pass="Manoj@123";
		Connection conn=DriverManager.getConnection(url,user, pass);
		conn.setAutoCommit(false);
		Statement st=conn.createStatement();
		st.executeUpdate("insert into faculty values('manoj', 1, 'cse')");
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
