package Management_System.Connection;

import java.sql.*;


public class Connection {

	private String path = "jdbc:mysql://localhost:3306/db_fp";
	private String username = "root";
	private String password = "085775643128";

	private java.sql.Connection conn = null;
	private Statement mystmt = null;
	private PreparedStatement prepstmt = null;

	public Connection() {
		try {
			conn = DriverManager.getConnection(path, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public java.sql.Connection con(){
		return conn;
	}

	public Statement mystmt() {
		try {
			mystmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mystmt;
	}

	public PreparedStatement prepstmt(String query){
		try {
			prepstmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prepstmt;
	}
}
