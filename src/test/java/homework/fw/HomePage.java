package homework.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By loginLink = By.xpath("//a[normalize-space()='Log in']");
    By shoppingCartLink = By.xpath("//span[normalize-space()='Shopping cart']");

    By secondProductName = By.xpath("(//h2[@class='product-title']/a)[2]");
    By secondProductAddToCartButton = By.xpath("(//input[@value='Add to cart'])[2]");

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public String getSecondProductName() {
        return driver.findElement(secondProductName).getText();
    }

    public void clickSecondProductAddToCart() {
        driver.findElement(secondProductAddToCartButton).click();
    }

    public void clickShoppingCart() {
        driver.findElement(shoppingCartLink).click();
    }
}