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
        String title = userInput.nextLine();
        Post post1 = new Post(title);
        post1.postInfo();
    }

    /*else if (choice == 2) {
        for (int i = 1; i < dataStore.nextPostId; i++) {
            Post post = dataStore.getPost(i);
            System.out.println("ID: " + i);
            System.out.println("Title: " + post.getTitle());
            System.out.println("Text: " + post.getText());
            System.out.println("Author: " + post.getAuthor());
            System.out.println("Date: " + post.getFormattedDateTime());
            System.out.println("--------------------------------------------------");
        }
    }*/

    else{
        System.out.println("Error!");
    }
    userInput.close();
}
}



 
