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

public class WordTests {
    WebDriver driver; WordPage wordPage; LoginPage loginPage;
    Properties properties = new Properties();

    @Before
    public void SetUp() throws IOException {

        driver = new FirefoxDriver();
        wordPage = new WordPage(driver); loginPage = new LoginPage(driver);
        InputStream inputStream = properties.getClass().getResourceAsStream("/Config.properties");
        properties.load(inputStream);
        System.out.println("Running tests on: "+properties.get("Environment"));
    }

    @Test
    public void AddNewWordTest() throws InterruptedException, IOException {
        Map<String, String> newWordDataSet = new InputDataSet().jsonReader(properties.getProperty("InputForWord"));
        loginPage.Login(properties);
        wordPage.AddNewWord(newWordDataSet);
        wordPage.AssertNewWordIsAdded();
    }

    @After
    public void TearDown()
    {
        driver.quit();
    }
}
