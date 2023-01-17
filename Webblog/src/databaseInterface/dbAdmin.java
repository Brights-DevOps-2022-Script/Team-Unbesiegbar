package databaseInterface;
import java.sql.*;

/*
 * Hier wird die Datenbank verwaltet.
 * 
 */
public class dbAdmin {
    
        // Bitte abwarten bis Roman eine Datenbank anlegt und diese in git teilt. Danke
        // createNewDatabase() muss auf einem System 1x ausgeführt werden, um eine Datenbank anzulegen. 
        public static void createNewDatabase(String fileName) {

            String url = "jdbc:sqlite:C:/sqlite/db/" + fileName; // Projektname.db
    
            try (Connection conn = DriverManager.getConnection(url)) {
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("The driver name is " + meta.getDriverName());
                    System.out.println("A new database has been created.");
                }
    
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        
        //erstellt neue Tabelle. Hardcoded! :s 
        public static void createNewTable() {

            String url = "jdbc:sqlite:C:/Users/Mein PC/Documents/SQLiteProj/SQLiteProj/src/test.db"; //Pfad muss angepasst werden. Siehe Methode createNewDatabase()
    
            String sql = "CREATE TABLE IF NOT EXISTS posts( " + "isbn integer PRIMARY KEY, " + "title TEXT NOT NULL, " 
            + "author TEXT NOT NULL, " + "category TEXT NOT NULL, " + "count integer" + ");";
    
            try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
                    stmt.execute(sql);
                if (conn != null) {
                }
    
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

}
