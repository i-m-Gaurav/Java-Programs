import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Random;

import javax.xml.transform.Result;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class question2 {
   

    public static void main(String[] args) {
        String str = "jdbc:mysql://localhost:3306/gaurav";
        Connection con = null;
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "0000");

        try {
            con = DriverManager.getConnection(str, props);
            if (con != null) {
                System.out.println("Successful");

                // String select = "select * from student";

                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
                System.out.println("Table Records before Insertion:");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getDate("dob"));
                }
            
                // Insert multiple records using a loop
                for (int i = 1; i <= 5; i++) {
                    // Move the cursor to the insert row
                    rs.moveToInsertRow();

            
                    // Set the values for the columns of the new row
                    rs.updateInt("id", i);
                    rs.updateString("name", "Employee " + i);
                    rs.updateDate("dob", Date.valueOf("1990-01-01"));
            
                    // Insert the new row
                    rs.insertRow();
            
                    // Display the table records after each insertion
                    rs.beforeFirst();
                    System.out.println("\nTable Records after Insertion #" + i + ":");
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getDate("dob"));
                    }
                }
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
  
}
