package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.core.BasePage;
import org.openqa.selenium.WebElement;

public class LandingScreen extends BasePage {

    @AndroidFindBy(accessibility = "com.example.android.uamp:id/title")
    private static WebElement toolBar;

    public LandingScreen(AppiumDriver homePageDriver) {
        super(homePageDriver);
    }

    public GenresMenuScreen navigateToGenresPage() {
        getMenuItem("Genres").click();
        return new GenresMenuScreen(driver);
    }
}
