package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    //opening browser
    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    //clising browser
    @After
    public void teardown() {

        closeBrowser();
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
      clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        //finding element for registration tab
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //finding element for gender/male radio button
        clickOnElement(By.id("gender-male"));
        //finding first name element
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Pooja");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Patel");
        //finding day of birth text box element
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]"), "10");
        //finding element for month tab
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]"), "May");
        //finding year tab element
        sendTextToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]"), "1980");
        //finding email field element
        sendTextToElement(By.xpath("//input[@id='Email']"), "Testing123@gmail.com");
        //sending email to email field
        //finding password field element
        sendTextToElement(By.xpath("//input[@id='Password']"), "Test1234567");
        //finding confirm password element
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Test1234567");
        //finding register field element
        clickOnElement(By.xpath("//button[@id='register-button']"));
        String expectedMessage = "Your registration completed";
        String actualMessage = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Registration Completed", expectedMessage, actualMessage);


    }

}
