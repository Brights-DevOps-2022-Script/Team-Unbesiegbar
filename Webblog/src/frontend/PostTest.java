package frontend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostTest {
    
    @Test
    public void getDate_Test() {
        //Daten vorbereiten
        Post post = new Post("Datum Test");
        //Logik ausführen
        
        String date = post.getDate();
        //Ergebnisse vergleichen
        int datelength = date.length();
        Assertions.assertEquals(19, datelength);
        // test für Connection in neuer klasse Assertions.assertNotN
        // insert () testen mit einem Post -> insert ausführen
        // -> id vergleichen
    }
}
