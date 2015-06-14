package Word;
import java.util.*;

public class WordPageMap {

   //This is a map of word input json feild names and their locators
public static final HashMap<String, String> listOfLocatorsOnWord = new HashMap<String, String>();
    static {
        listOfLocatorsOnWord.put("Word_Original", "word original");
        listOfLocatorsOnWord.put("Word_Transliteration", "word transliteration");
        listOfLocatorsOnWord.put("Diacritic", "word diacritic");
        listOfLocatorsOnWord.put("Word_Translation", "word translation");
        listOfLocatorsOnWord.put("Related_Songs", "related songs");
        listOfLocatorsOnWord.put("People", "people");
        listOfLocatorsOnWord.put("Default_Reflection", "default reflection");
        listOfLocatorsOnWord.put("Other_Related_Reflections", "other related reflections");
        listOfLocatorsOnWord.put("Is_This_A_Root_Word", "root word");
        listOfLocatorsOnWord.put("Word_Intro_Excerpt_English", "word intro excerpt english");
        listOfLocatorsOnWord.put("Word_Intro_Excerpt_Hindi", "word intro excerpt hindi");
        listOfLocatorsOnWord.put("Word_Intro_English", "wordIntroductionEnglish");
        listOfLocatorsOnWord.put("Word_Intro_Original", "wordIntroductionOriginal");
        listOfLocatorsOnWord.put("Writer", "writer");
        listOfLocatorsOnWord.put("Display_Team", "display ajabshahar team");
        listOfLocatorsOnWord.put("Thumbnail_Url", "thumbnail url");
        listOfLocatorsOnWord.put("Show_On_Landing_Page", "show on landingpage");
        listOfLocatorsOnWord.put("Synonyms", "synonyms");
        listOfLocatorsOnWord.put("Related_Words", "related words");
        listOfLocatorsOnWord.put("Publish", "publish");
        listOfLocatorsOnWord.put("Meaning", "meaning");
    }
}
