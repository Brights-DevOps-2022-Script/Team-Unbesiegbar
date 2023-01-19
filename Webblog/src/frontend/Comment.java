package frontend;


public class Comment {
    private int commentID;
    private String commentMessage;

    Post post = new Post(3);

    public Comment(int commentID, String commentMessage, int postID) {
        this.commentID= commentID;
        this.commentMessage = commentMessage;

    }

}
