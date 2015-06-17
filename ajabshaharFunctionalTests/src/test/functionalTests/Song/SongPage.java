package Song;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class SongPage {

    public WebDriver webDriver;
    public SongPage(WebDriver webDriver){this.webDriver = webDriver;}
    public final String dropDownList = "//*[@title= '%s']//select";
    public final String hugeDropDownList = "//*[@input-model='%s']/button";
    public final String hugeListSearchBox = "//span[@input-model = '%s']//input[@type= 'text']";
    public final String firstItemInHugeListSearchResult = "//span[@input-model = '%s']/div[@class = 'checkboxLayer show']//span[contains(text(), '%s')]";
    public final String textBox = "//input[@name = '%s']";
    public final String bigTextArea = "//*[@name = '%s']//*[@contenteditable = 'true']";
    public final String songLink = "Song" ;
    public final String saveButton = "//button[@type='submit']" ;

    public WebElement getWebElement(String locator, String methodOfFindingElement)
    {
        methodOfFindingElement = methodOfFindingElement.toLowerCase();
        WebElement webElement = null;
        if (methodOfFindingElement.equals("xpath")) {
            webElement = webDriver.findElement(By.xpath(locator));

        } else if (methodOfFindingElement.equals("id")) {
            webElement = webDriver.findElement(By.id(locator));

        } else if (methodOfFindingElement.equals("linktext")) {
            webElement = webDriver.findElement(By.linkText(locator));
        } else {
            System.out.println("Please enter a valid method of finding element");
        }
        return webElement;
    }

    public void AddNewSong(Map<String, String> newSongDataSet) throws InterruptedException {
        getWebElement(songLink, "linktext").click();
        String newPageUrl = webDriver.getCurrentUrl();
        Assert.assertTrue("Landed on wrong page", newPageUrl.contains("songs"));
        SongPageMap fieldNames = new SongPageMap();
        for (Object key : newSongDataSet.keySet()) {
            String s = key.toString();
            //small text box
            if (s.equals("Duration") || s.equals("YouTubeVideoId") || s.equals("SoundCloudTrackId")
                    || s.equals("ThumbnailUrl") || s.equals("DownloadUrl")) {
                System.out.println(fieldNames.listOfLocatorsOnSong.get(key));
                getWebElement(String.format(textBox, fieldNames.listOfLocatorsOnSong.get(key)), "xpath")
                        .sendKeys(newSongDataSet.get(key).toString());

                //huge list drop down
            } else if (s.equals("Genres") || s.equals("Singer") || s.equals("Words") || s.equals("Reflections")) {
                SelectValuesFromHugeDropDownList(newSongDataSet.get(key).toString(), fieldNames.listOfLocatorsOnSong.get(key));

                //drop down list
            } else if (s.equals("Umbrella_Title")|| s.equals("Song_Title")) {
                SelectValuesFromDropDownList(fieldNames.listOfLocatorsOnSong.get(key));

                //big text area
            } else if (s.equals("SongLyricsOriginal")|| s.equals("SongLyricsTransliteration") || s.equals("SongLyricsTranslation")
                    || s.equals("About")) {
                getWebElement(String.format(bigTextArea, fieldNames.listOfLocatorsOnSong.get(key)), "xpath")
                        .sendKeys(newSongDataSet.get(key).toString());

            } else {
                System.out.println("Could not find element for: " + key.toString());

            }
        }
        getWebElement(saveButton, "xpath").click();
    }

    public void SelectValuesFromHugeDropDownList(String itemToSelect, String value) throws InterruptedException {
        getWebElement(String.format(hugeDropDownList, value),"xpath").click();
        Thread.sleep(2000);
        getWebElement(String.format(hugeListSearchBox, value), "xpath").sendKeys(itemToSelect);
        getWebElement(String.format(firstItemInHugeListSearchResult, value,itemToSelect), "xpath").click();
        getWebElement(String.format(hugeDropDownList, value),"xpath").click();
    }

    public void SelectValuesFromDropDownList(String fieldName) throws InterruptedException {
        getWebElement(String.format(dropDownList, fieldName), "xpath").click();
        Thread.sleep(1000);
        //TODO Add support for specific value selection from drop down.
        getWebElement(String.format(dropDownList + "/option[2]", fieldName), "xpath").click();
    }
}
