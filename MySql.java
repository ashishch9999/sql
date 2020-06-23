package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySql {
	public static void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("connection worked");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void connectionToMySql() { //remove parameter when sql table print in eclipse
		connection();
		String host = "jdbc:mysql://localhost/demo";
		String username = "root";
		String password = "password";
		try {
			Connection connect = DriverManager.getConnection(host, username, password); 
			
			//PreparedStatement statement =(PreparedStatement) connect.prepareStatement("INSERT INTO members(name,surname,email)VALUES(?,?,?)");
			//PreparedStatement statement =(PreparedStatement) connect.prepareStatement("DELETE FROM members where name=?");
			
			// print table data
			
			PreparedStatement statement =(PreparedStatement) connect.prepareStatement("SELECT * FROM members");
			ResultSet data = statement.executeQuery();
			while(data.next() ) {
				System.out.println("Name  : " + data.getObject("name") + "  Surname  : " + data.getObject("surname") + "  Email  : " + data.getObject("email"));
			}
			
			
			//statement.setString(1, name);
			//statement.setString(2, surname);
			//statement.setString(3, email);
			//statement.executeUpdate();
			statement.close();
			connect.close();
			System.out.println("connection created!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//connectionToMySql("John","Cena","jcena@gmail.com");
		//connectionToMySql("max","john","maxj@yahoo.com");
		//connectionToMySql("john","","");
		connectionToMySql();
	}

}
