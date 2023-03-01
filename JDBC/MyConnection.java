//Connect to mysql 
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
class MyConnection{
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
            }

            // write code here...


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(con != null)
            try{
                con.close();
            }
            catch(SQLException e)
            {
                
            }
        }
        
    }
}