package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	
	
	public Connection con;
	
	public Statement stmt;
	
	public Statement getStatement() throws SQLException, ClassNotFoundException {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String connection = "jdbc:mysql://localhost:3306/customer";
		
		String username ="root";
		String password = "password";
		Class.forName(driver);
		con = DriverManager.getConnection(connection, username, password);
		
		stmt =con.createStatement();
		return stmt;
		
		
		
	}

	public void insertData(String query) throws ClassNotFoundException, SQLException {
		
		Statement sta  =getStatement();
		
		sta.executeUpdate(query);
		
	}
	
	public ResultSet getData(String query) throws ClassNotFoundException, SQLException {
		
		ResultSet data = 	getStatement().executeQuery(query);
		return data;
		
		}
	
	public ResultSet updateData() throws ClassNotFoundException, SQLException {
		String query = null;
		ResultSet data = 	getStatement().executeQuery(query);
		return data;
		
		
	}
}
