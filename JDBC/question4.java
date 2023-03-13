import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class question4 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/gaurav";
        Connection conn = null;
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "0000");
        try {

            conn = DriverManager.getConnection(url, props);
            if (conn != null) {
                System.out.println("Successful");
            }
            
            CallableStatement stmt = conn.prepareCall("{call getResultSet(?, ?)}");

            // Set the input parameter for the stored procedure
            Scanner in= new Scanner(System.in);
            System.out.print("Enter Id: ");
            int id = in.nextInt();
            stmt.setInt(1, id);

            // Register the output parameter for the stored procedure
            stmt.registerOutParameter(2, Types.VARCHAR);

            // Execute the stored procedure
            stmt.execute();

            // Get the output parameter value from the stored procedure
            String str = stmt.getString(2);
            if(str==null)
            {
                System.out.println("Id not found");
            }
            else
            {
            System.out.println("Output parameter value: " + str);
            }
            // Close the statement and connection
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
 }}
}

