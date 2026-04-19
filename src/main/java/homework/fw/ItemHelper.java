package homework.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemHelper extends BaseHelper {

    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    private By secondProductName = By.xpath("(//h2[@class='product-title']/a)[2]");
    private By secondProductAddToCartButton = By.xpath("(//input[@value='Add to cart'])[2]");
    private By shoppingCartLink = By.cssSelector(".ico-cart");
    private By cartProductNames = By.cssSelector(".cart-item-row .product-name");

    public String getSecondProductName() {
        return getText(secondProductName);
    }

    public void addSecondProductToCart() {
        click(secondProductAddToCartButton);
    }

    public void openShoppingCart() {
        click(shoppingCartLink);
    }

    public boolean isProductInCartByName(String expectedProductName) {
        List<WebElement> products = driver.findElements(cartProductNames);

        for (WebElement product : products) {
            if (product.getText().equals(expectedProductName)) {
                return true;
            }
        }
        return false;
    }
}