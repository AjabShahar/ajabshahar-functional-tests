package org.ajabshahar.qa;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.ajabshahar.qa.pages.*;

public class SongsFeatureContentSteps {
    private final WebDriver driver;

    public SongsFeatureContentSteps() {
        this.driver = DriverFactory.getDriver();
    }


    @Step("Select a song thumbnail with title <Hiye Kaya Mein>")
    public void selectSongThumbnail(String title) {
        driver.get(SongsFCPage.SongsFCPageUrl);
        PageFactory.initElements(driver, SongsFCPage.class);
        SongsFCPage.selectFirstThumbnail();
    }

    @Step("Verify lightbox is loaded")
    public void verifyLightBoxLoaded() {
        SongsFCPage.verifyLightBoxLoaded();
    }
}
