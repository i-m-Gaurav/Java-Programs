import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class question3 {
    public static void main(String[] args) {
        // establish a connection to the database
        String str = "jdbc:mysql://localhost:3306/gaurav";
        Connection conn = null;
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "0000");
        // ...

        try {
            conn = DriverManager.getConnection(str, props);
            if (conn != null) {
                System.out.println("Successful");
            }
            // create a callable statement to call the stored procedure
            String callProc = "{ call proc1() }";
            CallableStatement stmt = conn.prepareCall(callProc);

            // execute the stored procedure
            boolean hasResults = stmt.execute();

            // display the results from the first table
            if (hasResults) {
                ResultSet rs = stmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                int numColumns = rsmd.getColumnCount();

                System.out.println("Results from the first table:");
                while (rs.next()) {
                    for (int i = 1; i <= numColumns; i++) {
                        System.out.print(rs.getObject(i) + "\t");
                    }
                    System.out.println();
                }
            }

            // move to the next result set (from the second table)
            hasResults = stmt.getMoreResults();

            // display the results from the second table
            if (hasResults) {
                ResultSet rs = stmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                int numColumns = rsmd.getColumnCount();

                System.out.println("\nResults from the second table:");
                while (rs.next()) {
                    for (int i = 1; i <= numColumns; i++) {
                        System.out.print(rs.getObject(i) + "\t");
                    }
                    System.out.println();
                }
            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
