package database_project1;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//import java.sql.ResultSet;
//import java.sql.SQLException;


// ================= MySQL Comments =====================
//
//i. show databases;
//ii. CREATE DATABASE IF NOT EXISTS database_project1;
//iii. use database_project1;
//iv. describe students;
//v. CREATE TABLE students(
//	     id INT AUTO_INCREMENT PRIMARY KEY,
//	     name VARCHAR(255) NOT NULL,
//	     age INT NOT NULL,
//	     marks DOUBLE NOT NULL
//	     );
//
//vi. INSERT INTO students(name,age,marks) VALUES("avijit",21,80);
//vii. select * FROM students;
//
//===============================================================



public class Main {
	
	private static final String url = "";
	private static final String username = "";
	private static final String password = "";
	
public static void main(String[] args) {

try {
	Class.forName("com.mysql.cj.jdbc.Driver");

}catch(ClassNotFoundException e) {
	System.out.print(e.getMessage());
}

try {
	Connection connection = DriverManager.getConnection(url,username,password);
	Statement statement = connection.createStatement();
	
	
	
//	=================================== Show All Data into Database Query
	
//	String showAllDataQuery = "select * from students";
//	
//	ResultSet resultSet = statement.executeQuery(showAllDataQuery);
//			
//	System.out.println("=========Student Data=============");
//	while(resultSet.next()) {
//		int id = resultSet.getInt("id");
//		String name = resultSet.getString("name");
//		int age = resultSet.getInt("age");
//		double marks = resultSet.getDouble("marks");
//		
//		System.out.println();
//		System.out.println("Id : "+id);
//		System.out.println("Name : "+name);
//		System.out.println("Age : "+age);
//		System.out.println("Marks : "+marks);
//		System.out.println();
//		
//	}
	
	
	
//	======================= Insert Data into Database Query
	
	String insertQuery = String.format("INSERT INTO students(name,age,marks) VALUES('%s',%d,%f)" , "Soma",43,70.0);
	
	int rowsAffected = statement.executeUpdate(insertQuery);
			
	System.out.println(rowsAffected);
	if(rowsAffected > 0) {
		System.out.println("Data inserted Successfully");
	}else {
		System.out.println("Data not inserted");
	}
	
			
}catch(SQLException e) {
	System.out.print(e.getMessage());
}






}
}
