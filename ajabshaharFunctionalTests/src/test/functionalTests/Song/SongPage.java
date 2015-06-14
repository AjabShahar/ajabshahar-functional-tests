package Song;

public class SongPage {

    public final String dropDownList = "//*[@title= '%s']//select";
    public final String hugeDownList = "//*[@input-model='%s']/button";
    public final String textBox = "//input[@name = '%s']";
    public final String bigTextArea = "//*[@name = '%s']//*[@contenteditable = 'true']";
}
