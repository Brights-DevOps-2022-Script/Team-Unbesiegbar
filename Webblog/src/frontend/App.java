package frontend;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {

        newpost();

    }

public static void newpost () {



    
    try (Scanner postIn = new Scanner(System.in)) {
        System.out.println("Please Enter title");
        String title = postIn.nextLine();
        
    Post post1 = new Post(title);
    post1.postInfo();
    }
    }
}