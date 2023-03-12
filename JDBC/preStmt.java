import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.xml.transform.Result;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

class preStmt {
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

                String select = "select * from student";

                // String select = "insert into student (name,roll,age,phone) values (?,?,?,?)";
                PreparedStatement prestmt = con.prepareStatement(select, ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = prestmt.executeQuery(select);


                // prestmt.setString(1, "Manish");
                // prestmt.setInt(2, 7);
                // prestmt.setInt(3, 31);
                // prestmt.setInt(4, 30220);

                // prestmt.executeUpdate();


                while (rs.next()) {
                    String name = rs.getString("name");
                    int roll = rs.getInt("roll");
                    int age = rs.getInt("age");
                    int phone = rs.getInt("phone");

                    System.out.println(name + "\t\t" + roll + "\t\t" + age + "\t\t" + phone);
                }
               
                

                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}