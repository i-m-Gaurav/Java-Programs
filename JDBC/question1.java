import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Random;
import java.sql.SQLException;
import java.sql.ResultSet;

class question1 {
    private static final int NUM_OF_EMPLOYEE = 10000;
    private static final Random RANDOM = new Random();

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

                String select = "insert into employee (id,name,dob) values (?,?,?)";
                PreparedStatement prestmt = con.prepareStatement(select, ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                // ResultSet rs = prestmt.executeQuery(select);

                for (int i = 1; i < NUM_OF_EMPLOYEE; i++) {
                    int id = i;
                    String name = "Emp " + i;
                    String dob = generateRandomDOB();

                    prestmt.setInt(1,id);
                    prestmt.setString(2, name);
                    prestmt.setString(3, dob);

                    prestmt.executeUpdate();
                }

                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private static String generateRandomDOB() {
        // generate random date of birth between 1950 and 2000
        int year = RANDOM.nextInt(51) + 1950;
        int month = RANDOM.nextInt(12) + 1;
        int day = RANDOM.nextInt(28) + 1;

        return String.format("%04d-%02d-%02d", year, month, day);
    }
}