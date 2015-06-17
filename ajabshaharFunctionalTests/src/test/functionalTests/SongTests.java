import Song.SongPage;
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

public class SongTests {
    WebDriver driver; SongPage songPage; LoginPage loginPage;
    Properties properties = new Properties();

    @Before
    public void SetUp() throws IOException {
        driver = new FirefoxDriver();
        songPage = new SongPage(driver); loginPage = new LoginPage(driver);
        InputStream inputStream = properties.getClass().getResourceAsStream("/Config.properties");
        properties.load(inputStream);
        System.out.println("Running tests on: "+properties.get("Environment"));
    }

    @Test
    public void AddNewSongTest() throws InterruptedException {
        Map<String, String> newSongDataSet = new InputDataSet().jsonReader(properties.getProperty("InputForSong"));
        loginPage.Login(properties);
        songPage.AddNewSong(newSongDataSet);
    }

    @After
    public void TearDown()
    {
        driver.quit();
    }
}
