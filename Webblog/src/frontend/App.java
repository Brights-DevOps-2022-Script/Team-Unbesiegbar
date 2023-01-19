package frontend;
import java.util.Scanner;
import databaseInterface.dbPost;
public class App {
    public static void main(String[] args) throws Exception {

        newpost();

    }

public static void newpost () {
    dbPost Posts = new dbPost();
    Posts.showAllPosts();
    

    Scanner userInput = new Scanner(System.in);

    System.out.println("What do you want to do? Please select: ");
    System.out.println("1. Create a new post");
    System.out.println("2. Read a post");
    
    int choice = userInput.nextInt();

    if (choice == 1) {
        System.out.println("Please enter the title of your new Post");
        Scanner postIN = new Scanner(System.in);
        String title = postIN.nextLine();
        Post post1 = new Post(title);
        post1.postInfo();
        postIN.close();
    }

    else if (choice == 2) {
        System.out.println("Please enter the id of the post");
        Scanner idIN = new Scanner(System.in);
        String postID = idIN.nextLine();
        dbPost Post = new dbPost();
        Post.showPost(postID);
        System.out.println("--------------------------------------------------");
        idIN.close();
    }
    

    else{
        System.out.println("Error!");
    }
    userInput.close();
}
}



 
