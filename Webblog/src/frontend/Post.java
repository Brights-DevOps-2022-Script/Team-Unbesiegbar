package frontend;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import databaseInterface.*;
public class Post {
    private String title;
    private int postID;
    private String date;

    public Post (String title){
        this.title = title;
        dbPost rndDB = new dbPost();
        postID = (int) rndDB.getLastpostID();
        postID++;
        LocalDateTime rawDateObj = LocalDateTime.now();
        DateTimeFormatter shortDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String date = rawDateObj.format(shortDate);
        this.date = date;
    }

    public void postInfo () {
        System.out.println("TITEL: " + this.title + " PostID: " + postID + " DATE: " + date);

        dbPost myDbPost = new dbPost();

        myDbPost.insert(postID, title, date);

    }
}
