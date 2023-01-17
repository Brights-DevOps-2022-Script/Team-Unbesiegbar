package frontend;
import databaseInterface.*;
public class Post {
    private String title;
    private int postID = 0;
    private String text;


    public Post (String title){
        this.title = title;
    }
    public void postInfo () {
        System.out.println("TITEL: " + this.title + " PostID: " + this.postID);

        dbPost myDbPost = new dbPost();

        myDbPost.insert(postID, title);

    }
}
