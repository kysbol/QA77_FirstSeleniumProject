package homework.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By productNames = By.cssSelector(".cart-item-row .product-name");

    public boolean isProductInCart(String expectedName) {
        List<WebElement> items = driver.findElements(productNames);

        for (WebElement item : items) {
            if (item.getText().equals(expectedName)) {
                return true;
            }
        }
        return false;
    }
}