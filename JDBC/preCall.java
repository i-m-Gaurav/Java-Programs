import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.xml.transform.Result;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class preCall {
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

                

                    CallableStatement cstmt = con.prepareCall("{CALL getNameByRoll(?, ?)}");
                    cstmt.setInt(1, 7); // set the rollNo parameter to 123
                    cstmt.registerOutParameter(2, java.sql.Types.VARCHAR); // register the nameOut parameter as an OUT
                                                                           // parameter
                    cstmt.execute();
                    String name = cstmt.getString(2); // get the value of the nameOut parameter
                    if (name == null) {
                        System.out.println("No matching record found.");
                    } else {
                        System.out.println("Name: " + name);
                    }
                    

                    con.close();

               

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}