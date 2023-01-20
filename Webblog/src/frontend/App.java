package frontend;
import java.util.Scanner;

import backend.Comment;
import backend.Post;
import databaseInterface.dbPost;

public class App {
    public static void main(String[] args) throws Exception {

    System.out.println("What do you want to do? Please select: ");
    System.out.println("1. Create a new post");
    System.out.println("2. Read a post");
    System.out.println("3. Show all posts");
    System.out.println("4. Delete a post");

    Scanner userInput = new Scanner(System.in);
    int choice = userInput.nextInt();
    
        if (choice == 1) {
            newpost();
        }

        else if (choice == 2) {
            showallposts();
            readpost();
        }

        else if (choice == 3){
            showallposts();
        }

        else if (choice == 4){
            showallposts();
            deletepost();
        }

        else {
            System.out.println("Input not valid!");
        }

    userInput.close();
    }

    public static void newpost(){
    
        System.out.println("Please enter the title of your new Post");
        Scanner postIN = new Scanner(System.in);
        String title = postIN.nextLine();
        System.out.println("Enter your Name");
        String author = postIN.nextLine();
        System.out.println("Enter content of your post");
        String contents = postIN.nextLine();

        Post post1 = new Post(title, author, contents);
        post1.postInfo();
        postIN.close();

    }

    public static void readpost(){
        System.out.println("Please enter the id of the post");
        Scanner idIN = new Scanner(System.in);
        int postID = idIN.nextInt();
        Post myPost = new Post(postID);
        myPost.displayPost();
        System.out.println("Do yo wanna comment this post? y/n");
        //Show all comments
        /*Comment Comments = new Comment(PostID);
        Comments.displayAllComments();*/

            //leave your Comment
            Scanner userIN = new Scanner(System.in);
            char answer = userIN.next().charAt(0);
                if(answer == 'y'){

                    System.out.println("Please enter your name: ");
                    Scanner name = new Scanner(System.in);
                    String yourName = name.nextLine();
                    
                    System.out.println("Please enter your comment: ");
                    Scanner comment = new Scanner(System.in);
                    String yourComment = comment.nextLine();

                    Comment userComment = new Comment(yourComment, postID, yourName);
                    System.out.println("This is your comment: ");
                    userComment.CommentInfo();
                    
                    comment.close();
                    name.close();
                }
                else if(answer == 'n'){
                    System.out.println("Habe einen schoenen Tag");
                }
                else{
                    System.out.println("Input not valid");
                }
            userIN.close();
            

        System.out.println("--------------------------------------------------");
        idIN.close();
    }
    
    public static void showallposts(){
        dbPost allposts = new dbPost();
        allposts.showAllPosts();
    }

    public static void deletepost(){
        System.out.println("Please enter the id of the post");
        Scanner idIN = new Scanner(System.in);
        int postID = idIN.nextInt();
        Post delPost = new Post(postID);
        delPost.deletePost();
        System.out.println("--------------------------------------------------");
        idIN.close();
    }
}
