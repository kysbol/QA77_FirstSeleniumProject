package homework.tests;

import homework.core.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        String firstName = "Olga";
        String lastName = "Petrova";
        // String email = "petrova" + System.currentTimeMillis() + "@gmail.com";
        String email = "petrova10@gmail.com";
        String password = "password123!";

        openRegisterPage();
        selectGenderFemale();
        fillRegistrationForm(firstName, lastName, email, password);
        submitRegistration();

        Assert.assertTrue(
                isElementPresent(By.cssSelector(".ico-logout")),
                "Registration failed: Sign out button is not displayed."
        );
    }

    private void openRegisterPage() {
        click(By.xpath("//a[normalize-space()='Register']"));
    }

    private void selectGenderFemale() {
        click(By.id("gender-female"));
    }

    private void fillRegistrationForm(String firstName, String lastName, String email, String password) {
        typeByLabel("FirstName", firstName);
        typeByLabel("LastName", lastName);
        typeByLabel("Email", email);
        typeByLabel("Password", password);
        typeByLabel("ConfirmPassword", password);
    }

    private void submitRegistration() {
        click(By.id("register-button"));
    }
}