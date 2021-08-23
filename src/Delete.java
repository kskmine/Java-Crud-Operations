
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

    private static final String DELETE_USERS_SQL = "delete from person where id = ?;";

    public static void main(String[] argv) throws SQLException {
        Delete deleteExample = new Delete();
        deleteExample.deleteRecord();
    }

    public void deleteRecord() throws SQLException {
       
    	//System.out.println(DELETE_USERS_SQL);

    	DatabaseConnection dbc= new DatabaseConnection();
        dbc.connect();
        
    	PreparedStatement preparedStatement = dbc.connect().prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, 1);
            int result = preparedStatement.executeUpdate();
            System.out.println("Etkilenen kayýt sayýsý: " + result);
      
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}