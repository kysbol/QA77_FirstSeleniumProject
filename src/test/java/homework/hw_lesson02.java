package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class hw_lesson02 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("146").setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }

    @Test
    public void FindElements() {

        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        System.out.println(register.getText());

        List<WebElement> add_buttons = driver.findElements(By.xpath("//input[@value='Add to cart']"));
        System.out.println("Number of buttons:" + add_buttons.size());

        for (int i = 0; i < add_buttons.size(); i++) {
            WebElement button = add_buttons.get(i);
            System.out.println("Button " + (i + 1) + ": " + button.getAttribute("value"));
        }

        WebElement linkMyAccount = driver.findElement(By.xpath("//a[@class='account']"));
        System.out.println(linkMyAccount.getText());

        List<WebElement> linksInfo = driver.findElements(
                By.xpath("//div[@class='column information']//ul")
        );

        WebElement first = linksInfo.get(0);
        System.out.println(first.getText());
    }


    @AfterMethod

    public void tearDown() {
        if (driver != null) {

            driver.quit();
        }
    }
}
