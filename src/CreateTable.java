import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {

   

    private static final String createTableSQL = "CREATE TABLE person " +
    		"id INTEGER DEFAULT NEXTVAL('person_id_seq'),"+
    		"ad VARCHAR(50),"+
    		"soyad VARCHAR(50), "+
    		"yas VARCHAR(50)";
    
    public static void main(String[] argv) throws SQLException {
        CreateTable createTableExample = new CreateTable();
        createTableExample.createTable();
    }

    public void createTable() throws SQLException {

       // System.out.println(createTableSQL);
        
    	DatabaseConnection dbc= new DatabaseConnection();
        dbc.connect();           
            Statement statement = dbc.connect().createStatement();
            statement.execute(createTableSQL);
       
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