package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @After
    public void teardown(){
        closeBrowser();
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //finding element for login link
        clickOnElement(By.linkText("Log in"));
        //Expected Message
        String expectedMessage="Welcome, Please Sign In!";
        //find the welcome text element and get the text
        String actualMessage=getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
       clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        //find the email field element
        sendTextToElement(By.id("Email"),"Testing123@gmail.com");
         //find the password field element
       sendTextToElement(By.name("Password"),"Testing123");
        //find the login button and click on it
    clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        String actualResult=getTextFromElement(By.xpath("//a[contains(text(),'Log out')]"));
        String expectedMessage="Log out";
       clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
       Assert.assertEquals("Log out Successful",actualResult,expectedMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
         //find the email field element
       sendTextToElement(By.id("Email"),"Testing123@gmail.com");
        //find the password field
      sendTextToElement(By.name("Password"),"Test1234567");
    clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
    String expectedErrorMessage="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
    String actualErrorMessage=driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        //validate actual and expected message
        Assert.assertEquals("Error message not displayed",expectedErrorMessage,actualErrorMessage);

    }

}
