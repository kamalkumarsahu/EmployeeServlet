package com.nit.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private Connection con = null;

	public DbConnection() {
		// TODO Auto-generated constructor stub
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kumar", "kamal1996");
		}
		catch(Exception e){
			System.out.println("DataBase Connection Problem");
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}
}
