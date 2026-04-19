package homework.tests;

import homework.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    private final String email = "petrova11@gmail.com";
    private final String password = "password123!";

    @BeforeMethod
    public void precondition() {
        app.getUserHelper().login(email, password);
    }

    @Test
    public void addItemToCartTest() {
        String expectedProductName = app.getItemHelper().getSecondProductName();

        app.getItemHelper().addSecondProductToCart();
        app.getItemHelper().openShoppingCart();

        Assert.assertTrue(
                app.getItemHelper().isProductInCartByName(expectedProductName),
                "The selected product was not found in the shopping cart."
        );
    }
}