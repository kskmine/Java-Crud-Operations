import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection {
		
	    private final String url = "jdbc:postgresql://localhost/dbconn";
	    private final String user = "postgres";
	    private final String password = "29800";

	    public Connection connect() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url, user, password);

	          /*  if (conn != null) {
	                System.out.println("PostgreSQL servera ba�ar�l� bir �ekilde ba�lan�ld�.");
	            } else {
	                System.out.println("Ba�lant� Hatas�!");
	            }*/

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	        return conn;
	    }
	    
	    @SuppressWarnings("resource")
		public static void main(String[] args) {
	        DatabaseConnection app = new DatabaseConnection();
	        app.connect();
	    }
}
	