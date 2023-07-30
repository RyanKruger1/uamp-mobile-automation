import Pages.GenreScreen;
import Pages.GenresMenuScreen;
import Pages.LandingScreen;
import Pages.PlaybackScreen;
import io.qameta.allure.Description;
import org.core.BaseMobileClient;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MusicPlayerTests extends BaseMobileClient {

    static String genre;
    static String song;
    private LandingScreen landingScreen;
    private GenresMenuScreen genresMenuScreen;
    private GenreScreen genreScreen;
    private PlaybackScreen playbackScreen;

    public void loadTestData(String track) {
        genre = testData.getAsJsonObject(track).get("genre").getAsString();
        song = testData.getAsJsonObject(track).get("name").getAsString();
    }

    @Description("As a Mobile App User, I want to view the playback controls when I play a song.")
    @Test
    public void playbackWindowTest() throws Exception {
        loadTestData("song1");
        landingScreen = new LandingScreen(getDriver());
        genresMenuScreen = landingScreen.navigateToGenresPage();
        genreScreen = genresMenuScreen.navigateToGenrePlaylist(genre);
        genreScreen.playSong(song);
        Assert.assertEquals(genreScreen.songCurrentlyPlaying(), song);
    }

    @Description("As a Mobile App User, I want to view the full screen playback and use back button to navigate songs.")
    @Test
    public void playbackScreenPrevControlTest() throws Exception {
        loadTestData("song2");
        landingScreen = new LandingScreen(getDriver());
        genresMenuScreen = landingScreen.navigateToGenresPage();
        genreScreen = genresMenuScreen.navigateToGenrePlaylist(genre);
        genreScreen.playSong(song);
        playbackScreen = genreScreen.viewPlaybackScreen();
        playbackScreen.previousSong();
        Assert.assertFalse(playbackScreen.isSongPlaying(song));
    }

    @Description("As a Mobile App User, I want to view the full screen playback and use next button to navigate songs.")
    @Test
    public void playbackScreenNextControlTest() throws Exception {
        loadTestData("song3");
        landingScreen = new LandingScreen(getDriver());
        genresMenuScreen = landingScreen.navigateToGenresPage();
        genreScreen = genresMenuScreen.navigateToGenrePlaylist(genre);
        genreScreen.playSong(song);
        playbackScreen = genreScreen.viewPlaybackScreen();
        playbackScreen.nextSong();
        Assert.assertFalse(playbackScreen.isSongPlaying(song));
    }

    @Description("As a Mobile App User, I want to view the full screen playback and use the controls.")
    @Test
    public void playScreenTest() throws Exception {
        loadTestData("song4");
        landingScreen = new LandingScreen(getDriver());
        genresMenuScreen = landingScreen.navigateToGenresPage();
        genreScreen = genresMenuScreen.navigateToGenrePlaylist(genre);
        genreScreen.playSong(song);
        playbackScreen = genreScreen.viewPlaybackScreen();
        Assert.assertTrue(playbackScreen.isSongPlaying(song));
    }

    @Description("As a Mobile App User, I want to play a song and watch the progression of the seekbar over 2 seconds.")
    @Test
    public void playScreenSeekBarProgressionTest() throws Exception {
        loadTestData("song5");
        landingScreen = new LandingScreen(getDriver());
        genresMenuScreen = landingScreen.navigateToGenresPage();
        genreScreen = genresMenuScreen.navigateToGenrePlaylist(genre);
        genreScreen.playSong(song);
        playbackScreen = genreScreen.viewPlaybackScreen();
        Assert.assertFalse(playbackScreen.validateProgressionOfSeekbar());
    }
}