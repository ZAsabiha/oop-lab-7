import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegularTest {

    @Test
    void testReadToCsv() {
        Regular regularUser = new Regular("user1", "user1@example.com", 1234, 1, "Regular");
        regularUser.readtocsv();
        assertEquals("regular", regularUser.getUsertype());
    }

    @Test
    void testViewToCsv() {
        Regular regularUser = new Regular("user1", "user1@example.com", 1234, 1, "Regular");
        regularUser.viewtocsv();
        assertEquals("regular", regularUser.getUsertype());
    }

    @Test
    void testGetUsertype() {
        Regular regularUser = new Regular("user1", "user1@example.com", 1234, 1, "Regular");
        assertEquals("regular", regularUser.getUsertype());
    }
}
