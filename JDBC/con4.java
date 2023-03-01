//Connect to mysql 
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

class con4{

    

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
                String query = "insert into actor (actor_id, first_name) values (5,ravi)";
                try (Statement stmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)) {
                    ResultSet rs = stmt.executeQuery(query);

                        


                    while (rs.next()) {
                        int actor_id = rs.getInt("actor_id");
                        String first_name = rs.getString("first_name");
                        String last_name = rs.getString("last_name");
                        String last_update = rs.getString("last_update");
                        System.out.println(actor_id + "\t" + first_name + "\t" + last_name + "\t" + last_update);
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