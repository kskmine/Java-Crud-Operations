
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Insert {
  
    private static final String INSERT_USERS_SQL = "INSERT INTO person" +
        "(ad, soyad, yas) VALUES " +
        " (?, ?, ?);";

    public static void main(String[] argv) throws SQLException {
        Insert createTable = new Insert();
        createTable.insertRecord();
    }

    public void insertRecord() throws SQLException {
       
    	//System.out.println(INSERT_USERS_SQL);
    	DatabaseConnection dbc= new DatabaseConnection();
        dbc.connect();
  
            PreparedStatement preparedStatement = dbc.connect().prepareStatement(INSERT_USERS_SQL);
            
         //   preparedStatement.setInt(1, 4);
            preparedStatement.setString(1, "Deniz");
            preparedStatement.setString(2, "Sarý");
            preparedStatement.setString(3, "20");

            System.out.println(preparedStatement);
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