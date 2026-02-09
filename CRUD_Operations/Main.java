package database_project1;

import java.sql.*;
import java.util.Scanner;
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
	
	
//	============================================================== Using batch statement
	
//	==================== INsert Data :-
	Scanner scanner = new Scanner(System.in);
	Statement statement = connection.createStatement();
	
	while(true) {
		System.out.print("Enter name : ");
		String name = scanner.next();
		
		System.out.print("Enter age : ");
		int age = scanner.nextInt();
		
		System.out.print("Enter marks : ");
		double marks = scanner.nextDouble();
		
		
		
		System.out.print("More Data insert(Y/N) : ");
		String choice = scanner.next();
		
		String insertQuery = String.format("INSERT INTO students(name,age,marks) value('%s',%d,%f)", name,age,marks);
		
		statement.addBatch(insertQuery);
	
		if(choice.toUpperCase().equals("N")) {
			break;
		}
	}
	
	int[] arr = statement.executeBatch();
	
	for(int i = 0; i<arr.length ; i++) {
		if(arr[i] == 0) {
			System.out.println("Query "+(i+1)+" not Inserted Successfully");
		}
	}
	
	scanner.close();
	
	
	
	
	
//	================================================================ Using PrepareStatement Interface :-
	
	
//	=================================== Show All Data into Database Query :-
	
//	String showAllDataQuery = "SELECT * FROM students";
//	
//	PreparedStatement  prepareStatement = connection.prepareStatement(showAllDataQuery);
//	
//	ResultSet resultSet = prepareStatement.executeQuery();
//	
//	
//	System.out.println("=========Student Data=============");
//	while(resultSet.next()) {
//		int id = resultSet.getInt("id");
//		String name = resultSet.getString("name");
//		int age = resultSet.getInt("age");
//		double makrs = resultSet.getDouble("age");
//		System.out.println();
//		System.out.println("ID : "+id);
//		System.out.println("NAME : "+name);
//		System.out.println("AGE : "+age);
//		System.out.println("MARKS : "+makrs);
//		System.out.println();
//	}
	
	
//	=================================== Insert Data into Database Query :-
	
//	String insertQuery = "INSERT INTO students(name,age,marks) value(?,?,?)";
//	
//	PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
//	preparedStatement.setString(1, "amit");
//	preparedStatement.setInt(2, 20);
//	preparedStatement.setDouble(3, 50.60);
//	
//	int rowsAffected = preparedStatement.executeUpdate();
//	
//	if(rowsAffected > 0) {
//		System.out.println("Data Insert Successfully");
//	}else {
//		System.out.println("Data not Insert");
//	}
	

//	=================================== Update Data into Database Query :-
	
	
//	String updateQuery = "UPDATE students set marks = ? WHERE id = ?";
//	
//	PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
//	preparedStatement.setInt(1,60);
//	preparedStatement.setInt(2,6);
//	int rowsAffected = preparedStatement.executeUpdate();
//	
//	if(rowsAffected > 0) {
//		System.out.println("Data Updated Successfully");
//	}else {
//		System.out.println("Data not Updated");
//	}
	
	
//	=================================== Delete Data into Database Query :-
	
	
//	String deleteQuery = "DELETE FROM students WHERE id = ?";
//	
//	PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
//	preparedStatement.setInt(1,6);
//	int rowsAffected = preparedStatement.executeUpdate();
//	
//	if(rowsAffected > 0) {
//		System.out.println("Data Deleted Successfully");
//	}else {
//		System.out.println("Data not Deleted");
//	}
	
	
	
//  ====================================XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX=============================================
	
	
	
//	================================================================ Using Statement Interface :-
	
//	Statement statement = connection.createStatement();
	
//	=================================== Show All Data into Database Query :-
	
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
	
	
	
//	======================= Insert Data into Database Query :-
	
//	String insertQuery = String.format("INSERT INTO students(name,age,marks) VALUES('%s',%d,%f)" , "Soma",43,70.0);
//	
//	int rowsAffected = statement.executeUpdate(insertQuery);
//			
//	System.out.println(rowsAffected);
//	if(rowsAffected > 0) {
//		System.out.println("Data inserted Successfully");
//	}else {
//		System.out.println("Data not inserted");
//	}
	

// ====================== Update Data into Database Query :-

	
//	String updateQuery = String.format("UPDATE students SET name = '%s' WHERE id = %d ", "laltu",4);
//	
//	int rowsAffected = statement.executeUpdate(updateQuery);
//	
//	if(rowsAffected > 0) {
//		System.out.println("Data Updated Successfully");
//	}else {
//		System.out.println("Data not Updated");
//	}
//	
			

//	=========================== Delete Data into Database Query :-
	
//	String deletQuery = String.format("DELETE FROM students WHERE id = %d", 5);
//	
//	int rowsAffected = statement.executeUpdate(deletQuery);
//	
//	if(rowsAffected > 0) {
//		System.out.println("Data Deleted Successfully");
//	}else {
//		System.out.println("Data Deleted");
//	}
	
	
}catch(SQLException e) {
	System.out.print(e.getMessage());
}






}
}
