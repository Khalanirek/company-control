package com.testPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBCConnection {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/pro001?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";

		try {
			System.out.println("Start connection to Database");
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("End connection to Database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
