package homework.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public By registerLink = By.xpath("//a[normalize-space()='Register']");
    public By loginLink = By.xpath("//a[normalize-space()='Log in']");
    public By femaleRadioButton = By.id("gender-female");
    public By firstNameField = By.id("FirstName");
    public By lastNameField = By.id("LastName");
    public By emailField = By.id("Email");
    public By passwordField = By.id("Password");
    public By confirmPasswordField = By.id("ConfirmPassword");
    public By registerButton = By.id("register-button");
    public By loginButton = By.xpath("//input[@value='Log in']");
    public By logoutButton = By.cssSelector(".ico-logout");

    public void openRegisterPage() {
        click(registerLink);
    }

    public void openLoginPage() {
        click(loginLink);
    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String password) {
        click(femaleRadioButton);
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(emailField, email);
        type(passwordField, password);
        type(confirmPasswordField, password);
    }

    public void submitRegistration() {
        click(registerButton);
    }

    public void registerNewUser(String firstName, String lastName, String email, String password) {
        openRegisterPage();
        fillRegistrationForm(firstName, lastName, email, password);
        submitRegistration();
    }

    public void login(String email, String password) {
        openLoginPage();
        type(emailField, email);
        type(passwordField, password);
        click(loginButton);
    }

    public boolean isLogoutPresent() {
        return isElementPresent(logoutButton);
    }
}