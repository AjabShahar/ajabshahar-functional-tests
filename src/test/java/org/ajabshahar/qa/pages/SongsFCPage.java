package org.ajabshahar.qa.pages;

import org.ajabshahar.qa.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SongsFCPage extends BasePage {
    public static String SongsFCPageUrl = Url+"/songs/featuredContent.html";

    private static final WebDriver driver = DriverFactory.getDriver();

    @FindBy(how = How.CSS, css = ".songs.thumbnail:first-child .image")
    public static WebElement firstThumbnail;

    @FindBy(how=How.CSS,css=".homepage-content")
    public static WebElement homePage;

    public static void selectFirstThumbnail(){
        Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
        if (cp.getBrowserName().equals("chrome")) {
            try {
                ((JavascriptExecutor) driver).executeScript(String.format("window.scrollTo(0, {0});", firstThumbnail.getLocation().getY()));
            } catch (Exception e) {

            }
        }

        firstThumbnail.click();
    }

    public static void verifyLightBoxLoaded(){
        WebElement element = homePage.findElement(By.cssSelector(".popup-container .media-introduction"));
        Assert.assertNotNull(element);
    }
}
