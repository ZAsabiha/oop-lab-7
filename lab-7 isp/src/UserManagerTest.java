import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @Test
    void testSingletonInstance() {
        UserManager instance1 = UserManager.getInstance();
        UserManager instance2 = UserManager.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void testLoadUser() {
        UserManager userManager = UserManager.getInstance();
        assertFalse(userManager.users.isEmpty());
    }

    @Test
    void testLoadAdmin() {
        UserManager userManager = UserManager.getInstance();
        assertFalse(userManager.admins.isEmpty());
    }

    @Test
    void testAuthenticateUserSuccess() {
        UserManager userManager = UserManager.getInstance();
        boolean isAuthenticated = userManager.authenticate("user1", 1234);
        assertTrue(isAuthenticated);
    }

    @Test
    void testAuthenticateUserFailure() {
        UserManager userManager = UserManager.getInstance();
        boolean isAuthenticated = userManager.authenticate("nonexistentUser", 9999);
        assertFalse(isAuthenticated);
    }

    @Test
    void testAuthenticateAdminSuccess() {
        UserManager userManager = UserManager.getInstance();
        boolean isAuthenticated = userManager.authenticate("admin1", 4321);
        assertTrue(isAuthenticated);
    }

    @Test
    void testPerformFileOperationViewForRegularUser() {
        UserManager userManager = UserManager.getInstance();
        userManager.authenticate("user1", 1234);
        userManager.performFileOperation("view");
    }

    @Test
    void testPerformFileOperationAddForPowerUser() {
        UserManager userManager = UserManager.getInstance();
        userManager.authenticate("powerUser", 5678);
        userManager.performFileOperation("add");
    }

    @Test
    void testPerformFileOperationModifyForAdmin() {
        UserManager userManager = UserManager.getInstance();
        userManager.authenticate("admin1", 4321);
        userManager.performFileOperation("modify");
    }

    @Test
    void testPerformFileOperationUnauthorizedAdd() {
        UserManager userManager = UserManager.getInstance();
        userManager.authenticate("user1", 1234);
        userManager.performFileOperation("add");
    }

    @Test
    void testLogout() {
        UserManager userManager = UserManager.getInstance();
        userManager.authenticate("user1", 1234);
        assertNotNull(userManager.authenticatedUser);
        userManager.logout();
        assertNull(userManager.authenticatedUser);
    }
}
