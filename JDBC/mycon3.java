//Connect to mysql 
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

class mycon3{

    

    public static void main(String[] args) throws Exception {

       

        String constr = "jdbc:mysql://localhost:3306/sakila";
        Connection con = null;
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password","0000");
       
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(constr,prop);
            if(con != null){
                System.out.println("Database Connected Succesfully");
                try (Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    String query = "SELECT * FROM city";
                    ResultSet rs = stmt.executeQuery(query);
                   
                    // rs.beforeFirst();
                    // rs.updateString(2, "abhaiii");
                    // rs.absolute(2);
                    
                    
                
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                
                    // Print column names
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rsmd.getColumnName(i) + "\t");
                    }
                    System.out.println();
                    // System.out.println(stmt.getResultSet());
                
                    // Print rows
                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(rs.getString(i) + "\t");
                            
                        }
                        System.out.println();
                    }
                } catch (SQLException e) {
                    System.out.println("Error executing query: " + e.getMessage());
                }
                



            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch(SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        
        
    }
}