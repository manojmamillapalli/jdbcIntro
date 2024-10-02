package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertWithStatement {

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
        //get the statement object
        Statement st=conn.createStatement();
        st.executeUpdate("insert into employee values(102,'manoj naidu', 200000)");
        conn.close();
	}

}
