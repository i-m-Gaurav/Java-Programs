import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class update2 {
    public static void main(String[] args)  {
        String str = "jdbc:mysql://localhost:3306/gaurav";
        Connection con = null;
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "0000");

        try {
            con = DriverManager.getConnection(str, props);
            if(con != null){
                System.out.println("Successful");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String select = "select * from student";// put the where clause and then use the updateString or updateString and after that use updateRow to save the changes.
                ResultSet rs = stmt.executeQuery(select);
               


                
                while (rs.next()) {
                    String name = rs.getString("Name");
                    int Roll = rs.getInt("Roll");
                    int Age = rs.getInt("Age");
                    int Phone = rs.getInt("Phone");
                    System.out.println(name + "\t\t" + Roll + "\t\t" + Age + "\t\t" + Phone);



                    // rs.updateString("name", "Yashraj");
                    // rs.updateRow();
                }
                rs.close();
                 
                

                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}