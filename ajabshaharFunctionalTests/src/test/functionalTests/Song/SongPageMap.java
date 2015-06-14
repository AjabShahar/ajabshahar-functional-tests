package Song;

import java.util.HashMap;

public class SongPageMap {
    public static final HashMap<String, String> listOfLocatorsOnSong = new HashMap<String, String>();
    static {
        listOfLocatorsOnSong.put("Umbrella_Title", "Umbrella Title");
        listOfLocatorsOnSong.put("Song_Title", "Song Title");
        listOfLocatorsOnSong.put("Singer", "singers");
        listOfLocatorsOnSong.put("Words", "words");
        listOfLocatorsOnSong.put("Reflections", "reflections");
        listOfLocatorsOnSong.put("Duration", "duration");
        listOfLocatorsOnSong.put("YouTubeVideoId", "youtubeVideoId");
        listOfLocatorsOnSong.put("SoundCloudTrackId", "soundCloudTrackID");
        listOfLocatorsOnSong.put("ThumbnailUrl", "thumbnailUrl");
        listOfLocatorsOnSong.put("DownloadUrl", "downloadUrl");
        listOfLocatorsOnSong.put("Genres", "genres");
        listOfLocatorsOnSong.put("SongLyricsOriginal", "songLyricsOriginal");
        listOfLocatorsOnSong.put("SongLyricsTransliteration", "songLyricsTransliteration");
        listOfLocatorsOnSong.put("SongLyricsTranslation", "songLyricsTranslation");
        listOfLocatorsOnSong.put("About", "htmlcontent");
    }
}
