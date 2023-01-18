package frontend;
import databaseInterface.*;
public class Post {
    private String title;
    private int postID;
    private String text;
    private static int counter = 1;
    
    public Post (String title){
        this.title = title;
        postID += counter;
        counter++;
    }

    public void postInfo () {
        System.out.println("TITEL: " + this.title + " PostID: " + postID);

        dbPost myDbPost = new dbPost();

        myDbPost.insert(postID, title);

    }
}
