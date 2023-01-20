package backend;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import databaseInterface.*;
public class Comment {
    private int commentID;
    private String date;
    private String contents;
    private String author;
    private dbComment myDbComment = new dbComment();
    private int postID;

    public String getCommentDate(){
        return date;
    }

    public int getCommentID(){
        return commentID;
    }

    public String getDate() {
        LocalDateTime rawDateObj = LocalDateTime.now();
        DateTimeFormatter shortDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String date = rawDateObj.format(shortDate);
        return date;
    }
    public int countCommentID() {
        dbComment rndDB = new dbComment();
        commentID = (int) rndDB.getLastCommentID();
        commentID++;
        return commentID;
    }

    public Comment (int commentID){
        this.commentID = commentID;
    }

    public Comment (String contents, int postID, String author){
        this.postID = postID;
        this.contents = contents;
        this.commentID = countCommentID();
        this.author = author;
        this.date = getDate();
    }

    public void CommentInfo () {
        System.out.println("CommentID: " + commentID +" CONTENTS " + contents + " AUTHOR: " + author + " DATE: " + date);  //schoen machen

        myDbComment.insertComment(commentID, contents, author, date, postID);

    }


    public void displayComment(){
    
        myDbComment.showComments(postID);
    }
    
    public void deleteComment(){
        myDbComment.removeComment(commentID);
        System.out.println("Comment has been deleted!");
    }
}
