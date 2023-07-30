package org.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    @AndroidFindBy(id = "com.example.android.uamp:id/title")
    private static List<WebElement> menuList;
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BasePage(AndroidDriver homePageDriver) {
        this.driver = homePageDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getMenuItem(String menuItemName) {
        for (WebElement menuItem : menuList) {
            if (menuItem.getText().equals(menuItemName)) {
                return menuItem;
            }
        }
        throw new NotFoundException("Could not find item in menu: " + menuItemName);
    }
}
