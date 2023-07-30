package Pages;

import io.appium.java_client.AppiumDriver;
import org.core.BasePage;

public class GenresMenuScreen extends BasePage {


    public GenresMenuScreen(AppiumDriver driver) {
        super(driver);
    }

    public GenreScreen navigateToGenrePlaylist(String genreName) throws Exception {
        getMenuItem(genreName).click();
        return new GenreScreen(driver);
    }
}
