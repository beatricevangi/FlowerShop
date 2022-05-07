import Main.LoginMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginMenuTest {
    private static LoginMenu lm = new LoginMenu();

    @Test
    void encode() {
        String password = "passwordsegretissima";
        assertNotEquals(password, lm.encode(password));
    }
}