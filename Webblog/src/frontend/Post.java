package frontend;

public class Post {
    private String title;
    private int postID;
    private String text;


    public Post (String title, int postID){
        this.title = title;
        this.postID = postID;
    }
    public void postInfo () {
        System.out.println("TITEL: " + this.title + " PostID: " + this.postID);
    }
}
