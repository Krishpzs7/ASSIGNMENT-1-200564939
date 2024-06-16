import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtility {
    private static final String DB_URL = "jdbc:mysql://your-aws-db-endpoint:3306/MovieBoxOffice";
    private static final String USER = "yourusername";
    private static final String PASS = "yourpassword";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getMovieData() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Movies";
            return stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getBoxOfficeData() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM BoxOffice";
            return stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
