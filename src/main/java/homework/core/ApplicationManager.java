package homework.core;

import homework.fw.ItemHelper;
import homework.fw.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    private WebDriver driver;
    private UserHelper userHelper;
    private ItemHelper itemHelper;

    public void init() {
        WebDriverManager.chromedriver().browserVersion("146").setup();
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        userHelper = new UserHelper(driver);
        itemHelper = new ItemHelper(driver);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public ItemHelper getItemHelper() {
        return itemHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }
}