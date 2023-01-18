package databaseInterface;
import java.sql.*;
import ConfJava.JavaConf;

public class dbPost {
    JavaConf myConf = new JavaConf();
    String myUrl = myConf.myUrl();

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

    // insert zwei Mal vorhanden. 1. für Testzwecke. 2. kann Posttext empfangen
    public void insert(int postId, String title) {
        String sql = "INSERT INTO postMVP(postId, title) VALUES(?,?)";  
        String url = myUrl; 
        // Class.forName("org.sqlite.JDBC");

        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, postId);
            pstmt.setString(2, title);
            pstmt.executeUpdate();
            if(conn != null){
                conn.commit();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void showAllPosts(){
        String sql = "SELECT postID, title FROM postMVP"; // Table anpassen nach Testphase
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("postID") +  "\t" + 
                                   rs.getString("title") + "\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public double getLastpostID(){
        String sql = "SELECT MAX (postID) as postID FROM postMVP;";
        double myDouble = 0;

        try (Connection conn = this.connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){
        myDouble = rs.getInt("postID");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
    return myDouble;
}
}
