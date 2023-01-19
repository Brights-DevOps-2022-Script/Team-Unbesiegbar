package frontend;


public class Comment {
    private int commentID;
    private String commentMessage;


    public Comment(int commentID, String commentMessage, int postID) {
        this.commentID= commentID;
        this.commentMessage = commentMessage;

    }

}
