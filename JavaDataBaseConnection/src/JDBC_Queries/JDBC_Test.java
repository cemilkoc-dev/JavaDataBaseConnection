package JDBC_Queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		// The format for jdbc:mysql://hostname:port/databaseName
		String url = "jdbc:mysql://localhost:3306/ebookshop" + "?serverTimezone=UTC";
		String username = "root";
		String password = "root";
		
		try {
			
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to the Database");
			
			// Allocate a 'Statement' Object in the connection
			statement = connection.createStatement();
			
			String select = "select * from books";
			System.out.println("The SQL Statement is: " + select);
			System.out.println();
			
			// Execute SQL select query. The result is returned in a ResultSet object
			resultSet = statement.executeQuery(select);
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString("title") + " - " + resultSet.getString("author"));
			}
			
			
		} catch (Exception e) {
			System.out.println("Error connecting to the database!");
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				connection.close();
			}
			
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			
		}
		
		
		
		
		
	}

}
