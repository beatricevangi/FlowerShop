import Main.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    public static Customer c;

    @BeforeAll
    static void setUp(){
        c = new Customer("testemail", "testname", "testsurname", "testaddress",
                "a2242ead55c94c3deb7cf2340bfef9d5bcaca22dfe66e646745ee4371c633fc8", false);
        assertNotNull(c);
        assertAll("c",
                () -> assertEquals("testemail", c.getEmail() ),
                () -> assertEquals("testname", c.getName()),
                () -> assertEquals("testsurname", c.getSurname() ),
                () -> assertEquals("testaddress", c.getAddress()),
                () -> assertEquals("a2242ead55c94c3deb7cf2340bfef9d5bcaca22dfe66e646745ee4371c633fc8",
                        c.getHashPass()));
    }

    @Test
    void viewInbox() {

    }

    @Test
    void clearInbox() {
    }

    @Test
    void createOrder() {
    }

    @Test
    void chooseProduct() {
    }
}