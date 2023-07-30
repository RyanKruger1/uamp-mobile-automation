package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GenreScreen extends BasePage {

    @AndroidFindBy(id = "com.example.android.uamp:id/fragment_playback_controls")
    private WebElement playbackControls;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Song currently playing']")
    private WebElement songCurrentlyPlaying;

    public GenreScreen(AppiumDriver homePageDriver) {
        super(homePageDriver);
    }

    public void playSong(String songName) {
        getMenuItem(songName).click();
    }

    public String songCurrentlyPlaying() {
        wait.until(ExpectedConditions.visibilityOf(playbackControls));
        return songCurrentlyPlaying.getText();
    }

    public PlaybackScreen viewPlaybackScreen() {
        playbackControls.click();
        return new PlaybackScreen(driver);
    }
}