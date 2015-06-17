import Reflection.ReflectionPage;
import Word.WordPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class ReflectionTests {
    WebDriver driver; ReflectionPage reflectionPage; LoginPage loginPage;
    Properties properties = new Properties();

    @Before
    public void SetUp() throws IOException {

        driver = new FirefoxDriver();
        reflectionPage = new ReflectionPage(driver); loginPage = new LoginPage(driver);
        InputStream inputStream = properties.getClass().getResourceAsStream("/Config.properties");
        properties.load(inputStream);
        System.out.println("Running tests on: "+properties.get("Environment"));
    }

    @Test
    public void AddNewReflectionTest() throws InterruptedException, IOException {
        Map<String, String> newReflectionDataSet = new InputDataSet().jsonReader(properties.getProperty("InputForReflection"));
        loginPage.Login(properties);
        reflectionPage.AddNewReflection(newReflectionDataSet);
//        reflectionPage.AssertNewReflectionIsAdded();
    }

    @After
    public void TearDown()
    {
        driver.quit();
    }
}
