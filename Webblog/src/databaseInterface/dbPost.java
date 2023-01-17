package databaseInterface;
import java.sql.*;


public class dbPost {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/Mein PC/Documents/SQLiteProj/SQLiteProj/src/test.db";    //Pfad muss angepasst werden. Siehe Methode dbAdmin.createNewDatabase()
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    // insert zwei Mal vorhanden. 1. für Testzwecke. 2. kann Posttext empfangen
    public void insert(int postId, String title, String author) {
        String sql = "INSERT INTO books(postId, title, author) VALUES(?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, postId);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void insert(int postId, String title, String author, String text) {
        String sql = "INSERT INTO books(postId, title, author, text) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, postId);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setString(4, text);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
