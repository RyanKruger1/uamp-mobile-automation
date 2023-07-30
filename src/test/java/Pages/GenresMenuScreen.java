package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.core.BasePage;

public class GenresMenuScreen extends BasePage {

    public GenresMenuScreen(AndroidDriver driver) {
        super(driver);
    }

    public GenreScreen navigateToGenrePlaylist(String genreName) {
        getMenuItem(genreName).click();
        return new GenreScreen(driver);
    }
}