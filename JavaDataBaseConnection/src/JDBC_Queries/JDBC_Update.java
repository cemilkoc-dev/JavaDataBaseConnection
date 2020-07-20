package JDBC_Queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Update {

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

			String sqlUpdate = "update books set price = price * 0.9, qty = qty + 5 where id = 1";
			System.out.println("The SQL statement is " + sqlUpdate);
			statement.executeUpdate(sqlUpdate);
			
			System.out.println();
			// Increase the price by 50% "A cup of Java"
			String sqlUpdate2 = "update books set price = price * 1.5 where id = 4";
			System.out.println("The SQL statement is " + sqlUpdate2);
			statement.executeUpdate(sqlUpdate2);
			
			
			resultSet = statement.executeQuery("select * from books");

			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + ", " + resultSet.getString("title") + ", "
						+ resultSet.getString("author") + ", " + resultSet.getDouble("price") + ", "
						+ resultSet.getInt("qty"));
			}
			
			// CRUD Create, Read, Update, Delete
			// Insert - Create
			// Select - Read
			// Update - Update
			// Delete - Delete
			

		} catch (Exception e) {
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
