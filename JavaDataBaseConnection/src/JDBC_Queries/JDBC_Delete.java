package JDBC_Queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Delete {

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

			statement = connection.createStatement();
			
			// Write a statement to delete from books where ids are 2, 3
			String sqlDelete = "delete from books where id >= 2 and id < 4";
			System.out.println("The SQL statement is " + sqlDelete);
			
			int countDeleted = statement.executeUpdate(sqlDelete);
			System.out.println(countDeleted + "rows deleted\n");
			
			
			resultSet = statement.executeQuery("select * from books");
			
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + ", " + resultSet.getString("title")
								+ ", " + resultSet.getString("author") 
								+ ", " + resultSet.getDouble("price")
								+ ", " + resultSet.getInt("qty")
						);
			}
			
			
			

		} catch (Exception e) {
			System.out.println("Error connecting to the database!");
			e.printStackTrace();
		} finally {
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
