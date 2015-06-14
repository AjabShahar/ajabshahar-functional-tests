import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver driver){
        this.webDriver = driver;
    }

    public void Login(Properties properties) throws InterruptedException {
        webDriver.get((String)properties.get("LoginUrl"));
        webDriver.findElement(By.name("userName")).sendKeys((String)properties.get("UserName"));
        webDriver.findElement(By.name("password")).sendKeys((String)properties.get("Password"));
        webDriver.findElement(By.xpath("//button")).click();
        Thread.sleep(5000);
        if (!(webDriver.getCurrentUrl().contains("home")))
            webDriver.get((String)properties.get("HomePageUrl"));
        Assert.assertTrue("Landed on wrong page", webDriver.getCurrentUrl().contains("home"));
    }
}
