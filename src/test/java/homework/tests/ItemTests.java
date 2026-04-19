package homework.tests;

import homework.core.TestBase;
import homework.fw.CartPage;
import homework.fw.HomePage;
import homework.fw.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    CartPage cartPage;

    @BeforeMethod
    public void precondition() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);

        homePage.clickLogin();
        loginPage.login("petrova10@gmail.com", "password123!");
    }

    @Test
    public void addItemToCartTest() {
        String expectedProductName = homePage.getSecondProductName();

        homePage.clickSecondProductAddToCart();
        homePage.clickShoppingCart();

        Assert.assertTrue(cartPage.isProductInCart(expectedProductName),
                "Selected product was not found in the shopping cart.");
    }
}