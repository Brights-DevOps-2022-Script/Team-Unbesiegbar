package backend;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import databaseInterface.*;
public class Post {
    private String title;
    private int postID;
    private String date;
    private String contents;
    private String author;
    private dbPost myDbPost = new dbPost();

    public String getPostDate(){
        return date;
    }

    public int getPostID(){
        return postID;
    }

    public String getDate() {
        LocalDateTime rawDateObj = LocalDateTime.now();
        DateTimeFormatter shortDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String date = rawDateObj.format(shortDate);
        return date;
    }
    public int countPostID() {
        dbPost rndDB = new dbPost();
        postID = (int) rndDB.getLastpostID();
        postID++;
        return postID;
    }

    public Post (int postid){
        this.postID = postid;
    }

    public Post (String title, String author, String contents){
        this.title = title;
        this.author = author;
        this.contents = contents;
        this.date = getDate();
        this.postID = countPostID();
    }

    public void postInfo () {
        System.out.println("PostID: " + postID + " TITEL: " + this.title + " AUTHOR: " + author + " CONTENTS " + contents + " DATE: " + date);  //schoen machen

        myDbPost.insert(postID, title, author, contents, date);

    }

    public void displayAllPosts() {
        
        dbPost myDbPost = new dbPost();
        myDbPost.showAllPosts();
    }


    public void displayPost(){
        String myString = null;
        myString = Integer.toString(postID);
        myDbPost.showPost(myString);
    }

    public void deletePost(){
        String myString = Integer.toString(postID);
        myDbPost.removePost(myString);
        System.out.println("Post has been deleted!");
    }
}
