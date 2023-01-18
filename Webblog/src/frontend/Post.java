package frontend;
import databaseInterface.*;
public class Post {
    private String title;
    private int postID;
    
    public Post (String title){
        this.title = title;
        dbPost rndDB = new dbPost();
        postID = (int) rndDB.getLastpostID();
        postID++;
    }

    public void postInfo () {
        System.out.println("TITEL: " + this.title + " PostID: " + postID);

        dbPost myDbPost = new dbPost();

        myDbPost.insert(postID, title);

    }
}
