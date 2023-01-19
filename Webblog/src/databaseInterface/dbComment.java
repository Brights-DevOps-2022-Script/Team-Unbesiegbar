package databaseInterface;
import java.sql.*;
import ConfJava.JavaConf;

public class dbComment {
    JavaConf myConf = new JavaConf();
    String myUrl = myConf.myUrl();
    String myTable = "commentTEST";

    private Connection connect() {
        // SQLite connection string
        String url = myUrl;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertComment(int commentID, String contents, String postid) {
        String sql = "INSERT INTO " + myTable + " (commentID, contents, postid) VALUES(?,?,?)";  
        String url = myUrl; 
        // Class.forName("org.sqlite.JDBC");

        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, commentID);
            pstmt.setString(2, contents);
            pstmt.setString(3, postid);
            pstmt.executeUpdate();
            if(conn != null){
                conn.commit();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
