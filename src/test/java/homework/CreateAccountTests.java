package homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test //(enabled = false)
    public void newUserRegisterPositiveTest() {

        //click on register link
        //choose gender: male or female in radio-buttons         ("female")
        //enter name                                             ("Olga")   //*[@id='FirstName']
        //enter surname                                          ("Petrova") //*[@id='LastName']
        //enter email                                            (petrova1@gmail.com) //*[@id='Email']
        //enter password                                         (password123!) //*[@id='Password']
        //confirm password                                       (password123!) //*[@id='ConfirmPassword']
        //click on Register button
        //assert SignOut is present

        click(By.xpath("//a[normalize-space()='Register']"));
        click(By.id("gender-female"));
        typeByLabel("FirstName", "Olga");
        typeByLabel("LastName", "Petrova1");
        typeByLabel("Email", "Petrova123@gmail.com");
        typeByLabel("Password", "password123!");
        typeByLabel("ConfirmPassword", "password123!");
        click(By.id("register-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));


    }

}
