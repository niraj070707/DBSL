import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		
		// Connection Object
		Connection connection = null;
		
		
		// Statement Object
		Statement statement = null;
		
		 
		// ResultSet Object
		ResultSet resultSet = null;
		
		
		// Mariadb Connection credentials
		String url = "jdbc:mariadb://localhost:3306/assi8";
		String user = "root";
		String password = "password";
		
		
		// Connect with the database
		try {
			
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Successfully connected to database !!!");
			
			statement = connection.createStatement();
			
			// DDL Statement - CREATE
			/*
			String sql = "CREATE TABLE user (id INT PRIMARY KEY, name VARCHAR(50))";
			statement.execute(sql);
			*/
			
			// DML Statement - INSERT
			/*
			String sql = "INSERT INTO user VALUES (1, 'Jethala Gada'), (2, 'Bhupendra Jogi')";
			statement.executeUpdate(sql);
			*/
			
			// DML Statement - SELECT
			/*
			String sql = "SELECT * FROM user";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println(resultSet.getString("id")+" "+resultSet.getString("name"));
			}
			*/
			
			// DML Statement - UPDATE
			/*
			String sql = "UPDATE user SET name='Atmaram Tukaram Bhide' WHERE id = 4";
			statement.executeUpdate(sql);
			*/
			
			// DML Statement - DELETE
			/*
			String sql = "DELETE FROM user WHERE id = 5";
			statement.executeUpdate(sql);
			*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			statement.close();
			connection.close();
		}
		
		
	}

}
