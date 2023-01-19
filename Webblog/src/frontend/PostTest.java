package frontend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PostTest {
    
    @Test
    public void getDateLength_Test() {
        Post post = new Post("title","author","content");   //Daten vorbereiten
        String date = post.getDate();                                               //Logik ausführen
        int datelength = date.length();                                             //Ergebnisse vergleichen
        Assertions.assertEquals(19, datelength);
        // test für Connection in neuer klasse Assertions.assertNotN
        // insert () testen mit einem Post -> insert ausführen
        // -> id vergleichen
    }
    @Test
    public void getDate_Test(){
        Post post = new Post("title","author","content");
        String date = post.getDate();
        String postDate = post.getPostDate();
        Assertions.assertEquals(postDate, date);
    }
}
