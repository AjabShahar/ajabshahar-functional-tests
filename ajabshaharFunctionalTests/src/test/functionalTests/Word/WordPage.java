package Word;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class WordPage {
    public WebDriver webDriver;
    public WordPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public final String inputTextBox = "//input[@name = '%s']";
    public final String hugeListDropDown = "//span[@name = '%s']/button";
    public final String hugeListSearchBox = "//span[@name = '%s']//input[@type= 'text']";
    public final String firstItemInHugeListSearchResult = "//span[@name = '%s']/div[@class = 'checkboxLayer show']//span[contains(text(), '%s')]";
    public final String wordLink = "Word" ;
    public final String bigTextArea = "//*[@name='%s']//div[@contenteditable='true']" ;
    public final String dropDownList = "//select[@name='%s']" ;
    public final String saveButton = "//button[@type= 'submit']" ;

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

        System.out.println("Please enter a valid method of finding element");

    } else {
        System.out.println("Please enter a valid method of finding element");

    }
    return webElement;
}

    public void AddNewWord(Map newDataSet) throws InterruptedException {
        getWebElement(wordLink, "linktext").click();
        String newPageUrl = webDriver.getCurrentUrl();
        Assert.assertTrue("Landed on wrong page", newPageUrl.contains("words"));
        WordPageMap fieldNames = new WordPageMap();
        for (Object key : newDataSet.keySet()) {
            String s = key.toString();
            if (s.equals("Diacritic") || s.equals("Word_Original") || s.equals("Word_Translation") || s.equals("Word_Transliteration") || s.equals("Word_Intro_Excerpt_English") || s.equals("Word_Intro_Excerpt_Hindi") || s.equals("Thumbnail_Url")) {
                System.out.println(fieldNames.listOfLocatorsOnWord.get(key));
                getWebElement(String.format(inputTextBox, fieldNames.listOfLocatorsOnWord.get(key)), "xpath")
                        .sendKeys(newDataSet.get(key).toString());

                //huge list drop down
            } else if (s.equals("Related_Words") || s.equals("People") || s.equals("Related_Songs") || s.equals("Other_Related_Reflections") || s.equals("Writer") || s.equals("Synonyms")) {
                SelectValuesFromHugeDropDownList(newDataSet.get(key).toString(), fieldNames.listOfLocatorsOnWord.get(key));

                //drop down list
            } else if (s.equals("Default_Reflection") || s.equals("Is_This_A_Root_Word") || s.equals("Display_Team") || s.equals("Show_On_Landing_Page") || s.equals("Publish")) {
                SelectValuesFromDropDownList(fieldNames.listOfLocatorsOnWord.get(key));

                //big text area
            } else if (s.equals("Meaning")|| s.equals("Word_Intro_Original") || s.equals("Word_Intro_English")) {
                getWebElement(String.format(bigTextArea, fieldNames.listOfLocatorsOnWord.get(key)), "xpath")
                        .sendKeys(newDataSet.get(key).toString());

            } else {
                System.out.println("Could not find element for: " + key.toString());

            }
        }
        getWebElement(saveButton, "xpath").click();
    }

    public void SelectValuesFromHugeDropDownList(String itemToSelect, String value) throws InterruptedException {
        getWebElement(String.format(hugeListDropDown, value),"xpath").click();
        Thread.sleep(2000);
        getWebElement(String.format(hugeListSearchBox, value), "xpath").sendKeys(itemToSelect);
        getWebElement(String.format(firstItemInHugeListSearchResult, value,itemToSelect), "xpath").click();
        getWebElement(String.format(hugeListDropDown, value),"xpath").click();
    }

    public void SelectValuesFromDropDownList(String fieldName) throws InterruptedException {
        getWebElement(String.format(dropDownList, fieldName), "xpath").click();
        Thread.sleep(1000);
        //TODO Add support for specific value selection from drop down.
        getWebElement(String.format(dropDownList + "/option[2]", fieldName), "xpath").click();
    }

    public void AssertNewWordIsAdded() {
        webDriver.findElement(By.linkText("Words")).click();
        String newPageUrl = webDriver.getCurrentUrl();
        Assert.assertTrue("Landed on Wrong Page", newPageUrl.contains("words"));
    }
}