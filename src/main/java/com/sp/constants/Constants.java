package com.sp.constants;

public class Constants {

	public static final String INSERT_QUERY =
			"insert into employee "+ "(name,email,country) values"+"(?,?,?);";
	
	public static final String SELECT_ALL = 
			"select * from employee";
	
	public static final String CREATE_EMP = "/create";
	public static final String LIST_EMP = "/list";
	public static String DB_URL = "jdbc:mysql://localhost:3305/javadb?useSSL=false";
	public static String DB_USER = "root";
	public static String DB_PASS = "pradeep";
	public static String DB_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
}
