package frontend;
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

    public Comment (int commentID, String author, String contents){
        this.author = author;
        this.contents = contents;
        this.date = getDate();
        this.commentID = countCommentID();
    }

    public void CommentrInfo () {
        System.out.println("CommentID: " + commentID + " AUTHOR: " + author + " CONTENTS " + contents + " DATE: " + date);  //schoen machen

        myDbComment.insertComment(commentID, contents, postID);

    }

    public void displayAllComments() {
        
        dbComment myDbComment = new dbComment();
        myDbComment.showComments(postID);
    }


    public void displayComment(){
    
        myDbComment.showComments(postID);
    }

    /*public void deleteComment(){
        String myString = Integer.toString(commentID);
        myDbComment.removeComment(myString);
        System.out.println("Comment has been deleted!");
    }*/
}
