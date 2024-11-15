import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PowerTest {

    @Test
    void testReadToCsv() {
        Power powerUser = new Power("user2", "user2@example.com", 5678, 2, "Power");
        powerUser.readtocsv();
        assertEquals("power", powerUser.getUsertype(), "User type should be 'power'");
    }

    @Test
    void testViewToCsv() {
        Power powerUser = new Power("user2", "user2@example.com", 5678, 2, "Power");
        powerUser.viewtocsv();
        assertEquals("power", powerUser.getUsertype(), "User type should be 'power'");
    }

    @Test
    void testAddOrWriteToCsv() {
        Power powerUser = new Power("user2", "user2@example.com", 5678, 2, "Power");
        powerUser.addorwritetocsv();
        assertEquals("power", powerUser.getUsertype(), "User type should be 'power'");
    }

    @Test
    void testGetUsertype() {
        Power powerUser = new Power("user2", "user2@example.com", 5678, 2, "Power");
        assertEquals("power", powerUser.getUsertype(), "User type should be 'power'");
    }
}
