package frontend;
import java.util.Scanner;
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
            readpost();
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
        String postID = idIN.nextLine();
        dbPost Post = new dbPost();
        Post.showPost(postID);
        System.out.println("--------------------------------------------------");
        idIN.close();
    }
    
}




 
