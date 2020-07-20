package JDBC_Queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Insert {

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

			// INSERT a record
			String sqlInsert = "insert into books values (6, 'Gone Fishing', 'Jack Jones', 20.20, 66)";
			System.out.println("The SQL statement is " + sqlInsert + "\n");

			int countInserted = statement.executeUpdate(sqlInsert);
			System.out.println(countInserted + " rows inserted\n");

			// INSERT multiple records
			sqlInsert = "insert into books values " + "(7, 'Anna Karenina', 'Leo Tolstoy', 25.25, 22), "
					+ "(8, 'Crime and Punishment', 'Dostoevsky', 30.50, 44)";
			System.out.println("The SQL statement is " + sqlInsert + "\n");

			countInserted = statement.executeUpdate(sqlInsert);
			System.out.println(countInserted + " rows inserted\n");

			resultSet = statement.executeQuery("select * from books");

			while (resultSet.next()) {
				System.out.println(resultSet.getString("title") + " - " + resultSet.getString("author"));
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
