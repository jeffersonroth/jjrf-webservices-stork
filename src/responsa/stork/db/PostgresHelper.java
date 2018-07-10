package responsa.stork.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresHelper {

	private Connection conn;
	private String host;
	private String dbName;
	private String user;
	private String pass;
	
	protected PostgresHelper() {}
	
	public PostgresHelper(String host, String dbName, String user, String pass) {
		this.host = host;
		this.dbName = dbName;
		this.user = user;
		this.pass = pass;
		System.out.println("PostgresHelper " + this.host + this.dbName);
	}
	
	public boolean connect() throws SQLException, ClassNotFoundException {
		if (host.isEmpty() || dbName.isEmpty() || user.isEmpty() || pass.isEmpty()) {
			throw new SQLException("Database credentials missing");
		}
		System.out.println("Connecting to :" + this.host + this.dbName);
		try {
			Class.forName("org.postgresql.Driver");
			} catch(ClassNotFoundException e) {
				System.out.println("org.postgresql.Driver not found");
			}
		this.conn = DriverManager.getConnection(
				this.host + this.dbName,
				this.user, this.pass);
		System.out.println("Connected to :" + this.host + this.dbName);
		return true;
	}
	
	public ResultSet execQuery(String query) throws SQLException {
		
		System.out.println("PostgresHelper.java execQuery(" + query + ")");
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			if(this.connect()) {
				try {
				    stmt = this.conn.createStatement();

				    if (stmt.execute(query)) {
				    	System.out.println("Executing query...");
				        rs = stmt.getResultSet();
				    }
				}
				catch (SQLException ex){
				    // handle any errors
				    System.out.println("SQLException: " + ex.getMessage());
				    System.out.println("SQLState: " + ex.getSQLState());
				    System.out.println("VendorError: " + ex.getErrorCode());
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return this.conn.createStatement().executeQuery(query);
		if(rs.next()) {
		  System.out.println("ResultSet is not null");
		} else {
			System.out.println("ResultSet is null");
		}
		return rs;
		
	}
	
}
