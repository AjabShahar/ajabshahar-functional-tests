package Reflection;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class ReflectionPage {

    WebDriver webDriver;
    public final String inputTextBox = "//input[@name = '%s']";
    public final String bigTextArea = "//*[@name = '%s']//div[@contenteditable='true']";
    public final String reflectionLink = "Reflection" ;
    public final String saveButton = "//button[@type= 'submit']" ;

    public ReflectionPage(WebDriver webDriver){this.webDriver = webDriver;}

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

    public void AddNewReflection(Map<String, String> newReflectionDataSet) {
        getWebElement(reflectionLink, "linktext").click();
        String newPageUrl = webDriver.getCurrentUrl();
        Assert.assertTrue("Landed on wrong page", newPageUrl.contains("reflectionDetails"));
        ReflectionPageMap fieldNames = new ReflectionPageMap();
        for (Object key : newReflectionDataSet.keySet()) {
            String s = key.toString();
            //small text box
            if (
//                    s.equals("Title") || s.equals("YouTubeVideoId") ||
            s.equals("Verb") || s.equals("ThumbnailUrl") || s.equals("ReflectionExcerpt")|| s.equals("Duration")) {
                System.out.println(fieldNames.listOfLocatorsOnReflection.get(key));
                getWebElement(String.format(inputTextBox, fieldNames.listOfLocatorsOnReflection.get(key)), "xpath")
                        .sendKeys(newReflectionDataSet.get(key).toString());

                //huge list drop down
            } else if (s.equals("RelatedWords") || s.equals("RelatedSongs") || s.equals("RelatedPeople")) {
//                SelectValuesFromHugeDropDownList(newReflectionDataSet.get(key).toString(),
//                  fieldNames.listOfLocatorsOnReflection.get(key));

                //drop down list
            } else if (s.equals("NameOfSpeaker") || s.equals("ReflectionType") || s.equals("ShowOnLandingPage") || s.equals("Publish")) {
//                SelectValuesFromDropDownList(fieldNames.listOfLocatorsOnReflection.get(key));

                //big text area
            } else if (s.equals("About")) {
                getWebElement(String.format(bigTextArea, fieldNames.listOfLocatorsOnReflection.get(key)), "xpath")
                        .sendKeys(newReflectionDataSet.get(key).toString());

            } else {
                System.out.println("Could not find element for: " + key.toString());

            }
        }
        getWebElement(saveButton, "xpath").click();
    }
}
