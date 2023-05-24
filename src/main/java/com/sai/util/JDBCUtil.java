package com.sai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JDBCUtil {
	private static Connection con=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getJDBCConnection() throws SQLException, IOException {
		/*
		 * FileInputStream fis = new FileInputStream(
		 * "D:\\AdvJavaPrograms\\ServletApps\\JDBCCRUDAppUsingServlets\\src\\main\\java\\com\\sai\\resources\\application.properties"
		 * ); Properties props = new Properties(); props.load(fis);
		 */
		HikariConfig config = new HikariConfig("D:\\AdvJavaPrograms\\ServletApps\\JDBCCRUDAppUsingServlets\\src\\main\\java\\com\\sai\\resources\\application.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource.getConnection();
		//con = DriverManager.getConnection(props.getProperty("url"),props.getProperty("user"),props.getProperty("password"));
		//System.out.println("connected to the database");
		//return con;
	}
}
