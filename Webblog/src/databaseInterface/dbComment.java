package databaseInterface;
import java.sql.*;
import ConfJava.JavaConf;

public class dbComment {
    JavaConf myConf = new JavaConf();
    String myUrl = myConf.myUrl();
    String myTable = "commentTest2";

    private Connection connect() {
        String url = myUrl;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertComment(int commentID, String contents,String author, String date, int postid) {
        String sql = "INSERT INTO " + myTable + " (commentID, contents, author, date, postid) VALUES(?,?,?,?,?)";  
        String url = myUrl; 

        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, commentID);
            pstmt.setString(2, contents);
            pstmt.setString(3, author);
            pstmt.setString(4, date);
            pstmt.setDouble(5, postid);
            pstmt.executeUpdate();
            if(conn != null){
                conn.commit();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showComments(String postid){
        String sql = "SELECT commentID, contents, author, date, postid FROM " + myTable + "WHERE  postid=" + postid + ";"; // Table anpassen nach Testphase
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println("*** CommentID: " + rs.getInt("commentID") +  "\n" + 
                                   "*** Contents:   " + rs.getString("contents") + "\n" +
                                   "*** Author: " + rs.getString("author") + "\n" +
                                   "*** Date; " + rs.getString("date") + "\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getLastCommentID(){
        String sql = "SELECT MAX (commentID) as commentID FROM " + myTable +";";
        double myDouble = 0;

        try (Connection conn = this.connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){
        myDouble = rs.getInt("commentID");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
    return myDouble;
    }

    public void removeComment(int commentID){
        String myID = Integer.toString(commentID);
        String sql = "DELETE FROM " + myTable+ " WHERE postid = " + myID + ";";
        String url = myUrl; 


        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)){
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
    }
}
