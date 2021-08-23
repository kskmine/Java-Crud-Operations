
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

    private static final String UPDATE_USERS_SQL = "update person set name = ? where id = ?;";

    public static void main(String[] argv) throws SQLException {
        Update updateExample = new Update();
        updateExample.updateRecord();
    }

    public void updateRecord() throws SQLException {
      
    	//System.out.println(UPDATE_USERS_SQL);
        
    	DatabaseConnection dbc= new DatabaseConnection();
        dbc.connect();
    	
    	PreparedStatement preparedStatement = dbc.connect().prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, "Emine");
            preparedStatement.setInt(2, 1);

            preparedStatement.executeUpdate();
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