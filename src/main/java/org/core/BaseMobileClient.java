package org.core;

import com.google.gson.JsonObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.Getter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BaseMobileClient {
    public static JsonObject testData;
    protected static JsonReader reader = new JsonReader();
    @Getter
    private static AppiumDriver driver;

    @BeforeMethod
    public static void setup() throws IOException {
        driver = connectToAppiumServer();
        testData = reader.readTestData();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    protected static AppiumDriver connectToAppiumServer() throws IOException {
        File apkFile = new File("uamp-debug.apk");
        String apk = apkFile.getAbsoluteFile().toString();

        JsonObject emulatorInfo;
        emulatorInfo = reader.readCapabilities();
        int port = emulatorInfo.get("port").getAsInt();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, emulatorInfo.get("deviceOS").getAsString());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, emulatorInfo.get("deviceOSVersion").getAsString());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorInfo.get("avdName").getAsString());
        caps.setCapability(MobileCapabilityType.APP, apk);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("avd", emulatorInfo.get("avdName").getAsString());
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("unicodeKeyboard", true);

        URL url = new URL("http://0.0.0.0:" + port + "/wd/hub");

        driver = new AppiumDriver(url, caps);
        return driver;
    }
}