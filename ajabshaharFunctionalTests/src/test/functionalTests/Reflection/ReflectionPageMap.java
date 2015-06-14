package Reflection;

import java.util.HashMap;

public class ReflectionPageMap {
    public static final HashMap<String, String> listOfLocatorsOnReflection = new HashMap<String, String>();
    static {
        listOfLocatorsOnReflection.put("Verb", "verb");
        listOfLocatorsOnReflection.put("ThumbnailUrl", "thumbnailUrl");
        listOfLocatorsOnReflection.put("ReflectionExcerpt", "translation");
        listOfLocatorsOnReflection.put("Duration", "duration");
        listOfLocatorsOnReflection.put("About", "aboutText");
    }
}
