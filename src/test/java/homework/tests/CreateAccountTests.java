package homework.tests;

import homework.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        String firstName = "Olga";
        String lastName = "Petrova";
        // String email = "petrova" + System.currentTimeMillis() + "@gmail.com";
        String email = "petrova11@gmail.com";
        String password = "password123!";

        app.getUserHelper().registerNewUser(firstName, lastName, email, password);

        Assert.assertTrue(
                app.getUserHelper().isLogoutPresent(),
                "Registration failed: Logout button is not displayed."
        );
    }
}