package frontend;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        
        newpost();

    }

public static void newpost () {
    try (Scanner bookIn = new Scanner(System.in)) {
        System.out.println("Please Enter title and postID");
        String title = bookIn.nextLine();
        int postID = bookIn.nextInt();
        
    Post post1 = new Post(title, postID);
    post1.postInfo();
    }
    }
}