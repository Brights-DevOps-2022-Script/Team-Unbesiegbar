package databaseInterface;
import java.sql.*;
import ConfJava.JavaConf;

public class dbPost {
    JavaConf myConf = new JavaConf();
    String myUrl = myConf.myUrl();
    String myTable = "pierixmanOne";

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
    public void insert(int postId, String title, String date) {
        String sql = "INSERT INTO " + myTable + " (postId, title, date) VALUES(?,?,?)";  
        String url = myUrl; 
        // Class.forName("org.sqlite.JDBC");

        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, postId);
            pstmt.setString(2, title);
            pstmt.setString(3, date);
            pstmt.executeUpdate();
            if(conn != null){
                conn.commit();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(int postId, String title,  String author, String contents, String date) {
        String sql = "INSERT INTO " + myTable + " (postId, title, author, contents, date) VALUES(?,?,?, ?, ?)";  
        String url = myUrl; 
        // Class.forName("org.sqlite.JDBC");

        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, postId);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setString(4, contents);
            pstmt.setString(5, date);
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
        String sql = "SELECT postID, title, author FROM " + myTable; // Table anpassen nach Testphase
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println("Post ID: " + rs.getInt("postID") +  "\n" + 
                                   "Title: " + rs.getString("title") + "\n" +
                                   "Author: " + rs.getString("author") + "\n" +
                                   "------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showPost(String postID){
        String sql = "SELECT postID, title, author, contents, date FROM " + myTable + " WHERE postid = " + postID; // Table anpassen nach Testphase
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println("Post ID: " + rs.getInt("postID") +  "\n" + 
                                   "Title: " + rs.getString("title") + "\n" +
                                   "Author: " + rs.getString("author") + "\n" +
                                   "Contents: " + rs.getString("contents") + "\n" +
                                   "Date: " + rs.getString("date") + "\n" +
                                   "-----------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public double getLastpostID(){
        String sql = "SELECT MAX (postID) as postID FROM " + myTable +";";
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
