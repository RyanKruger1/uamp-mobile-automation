package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaybackScreen extends BasePage {

    @AndroidFindBy(id = "com.example.android.uamp:id/line1")
    private WebElement songNameElement;

    @AndroidFindBy(id = "com.example.android.uamp:id/next")
    private WebElement next;

    @AndroidFindBy(id = "com.example.android.uamp:id/prev")
    private WebElement prev;

    @AndroidFindBy(id = "com.example.android.uamp:id/startText")
    private WebElement startTime;

    public PlaybackScreen(AppiumDriver homePageDriver) {
        super(homePageDriver);
        wait.until(ExpectedConditions.visibilityOf(songNameElement));
    }

    public void nextSong() {
        next.click();
    }

    public void previousSong() {
        prev.click();
    }

    public boolean validateProgressionOfSeekbar() throws InterruptedException {
        String seekBarStartText = startTime.getText();
        Thread.sleep(2000);
        String seekBarStopText = startTime.getText();
        return seekBarStopText.equals(seekBarStartText);
    }

    public boolean isSongPlaying(String songName) {
        if (songNameElement.getText().equals(songName)) {
            return true;
        } else {
            return false;
        }
    }
}
