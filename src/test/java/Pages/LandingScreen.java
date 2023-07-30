package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.core.BasePage;

public class LandingScreen extends BasePage {

    public LandingScreen(AndroidDriver homePageDriver) {
        super(homePageDriver);
    }

    public GenresMenuScreen navigateToGenresPage() {
        getMenuItem("Genres").click();
        return new GenresMenuScreen(driver);
    }
}
