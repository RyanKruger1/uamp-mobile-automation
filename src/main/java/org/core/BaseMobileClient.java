package org.core;

import com.google.gson.JsonObject;
import io.appium.java_client.android.AndroidDriver;
import lombok.Getter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class BaseMobileClient {

    @Getter
    protected static AndroidDriver driver;
    protected static JsonObject testData;
    protected static JsonReader reader = new JsonReader();

    @BeforeMethod
    public static void setup() throws IOException {
        if (driver == null) {
            driver = connectToAppiumServer();
        } else {
            driver.resetApp();
        }

        testData = reader.readTestData();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    protected static AndroidDriver connectToAppiumServer() throws IOException {
        File apkFile = new File("uamp-debug.apk");
        String apk = apkFile.getAbsoluteFile().toString();

        JsonObject emulatorInfo;
        emulatorInfo = reader.readCapabilities();
        int port = emulatorInfo.get("port").getAsInt();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(PLATFORM_NAME, emulatorInfo.get("deviceOS").getAsString());
        caps.setCapability(PLATFORM_VERSION, emulatorInfo.get("deviceOSVersion").getAsString());
        caps.setCapability(DEVICE_NAME, emulatorInfo.get("avdName").getAsString());
        caps.setCapability(APP, apk);
        caps.setCapability(AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("avd", emulatorInfo.get("avdName").getAsString());
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("fullReset", true);

        URL url = new URL("http://0.0.0.0:" + port + "/wd/hub");

        driver = new AndroidDriver(url, caps);
        return driver;
    }
}