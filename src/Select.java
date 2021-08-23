import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    
    private static final String QUERY = "select ad,soyad,yas from person where id =?";
    private static final String SELECT_ALL_QUERY = "select * from person";

    
    public void getUserById() throws SQLException {
        
    	DatabaseConnection dbc= new DatabaseConnection();
        dbc.connect();
    	
            PreparedStatement preparedStatement = dbc.connect().prepareStatement(QUERY);
            preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
           
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
               // int id = rs.getInt("id");
                String name = rs.getString("ad");
                String surname = rs.getString("soyad");
                String age = rs.getString("yas");
                System.out.println(name + "," + surname + "," + age + ",");
            }
    }

    public void getAllUsers() throws SQLException {
        
    	DatabaseConnection dbc= new DatabaseConnection();
        dbc.connect();
        
          
            PreparedStatement preparedStatement = dbc.connect().prepareStatement(SELECT_ALL_QUERY);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
               // int id = rs.getInt("id");
                String name = rs.getString("ad");
                String surname = rs.getString("soyad");
                String age = rs.getString("yas");
                System.out.println(name + "," + surname + "," + age + ",");
            }
    }

    public static void main(String[] args) throws SQLException {
        Select example = new Select();
        example.getUserById();
        example.getAllUsers();
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