package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    //opening the browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //closing the browser
    @After
    public void teardown() {
        closeBrowser();
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //finding the element for computer tab
        clickOnElement(By.linkText("Computers"));
        //finding the element of actualmessage
        String actualComputerMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String expectedMessage = "Computers";
        //validate the actual and expect message
        Assert.assertEquals("User is not in a Computer Page", expectedMessage, actualComputerMessage);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        String actualElectronicMessage = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        String expectedMessage = "Electronics";
        //validate the actual and expect message
        Assert.assertEquals("User is not in a Electronics Page", expectedMessage, actualElectronicMessage);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        String actualApparelMessag = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        String expectedMessage = "Apparel";
        Assert.assertEquals("User is not in a Electronics Page", expectedMessage, actualApparelMessag);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
        String actualDigitalDownloadMessage = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
        String expectedMessage = "Digital downloads";
        Assert.assertEquals("User is not in a Digital Download Page", expectedMessage, actualDigitalDownloadMessage);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        clickOnElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.header-menu ul.top-menu.notmobile:nth-child(1) li:nth-child(5) > a:nth-child(1)"));
        String actualBooksMessage = getTextFromElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.header-menu ul.top-menu.notmobile:nth-child(1) li:nth-child(5) > a:nth-child(1)"));
        String expectedMessage = "Books";
        Assert.assertEquals("User is not in a Books Page", expectedMessage, actualBooksMessage);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        clickOnElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[6]"));
        String actualJewelryMessage = getTextFromElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[6]"));
        String expectedMessage = "Jewelry";
        Assert.assertEquals("User is not in a Books Page", expectedMessage, actualJewelryMessage);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        String actualGiftCardsMessage = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        String expectedMessage = "Gift Cards";
        Assert.assertEquals("User is not in a Books Page", expectedMessage, actualGiftCardsMessage);
    }


}
