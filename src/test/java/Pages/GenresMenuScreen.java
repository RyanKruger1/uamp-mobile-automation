package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.core.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GenresMenuScreen extends BasePage {

    public GenresMenuScreen(AndroidDriver driver) {
        super(driver);
    }

    public GenreScreen navigateToGenrePlaylist(String genreName) {
        wait.until(ExpectedConditions.elementToBeClickable(
                getMenuItem(genreName)
        )).click();
        return new GenreScreen(driver);
    }
}