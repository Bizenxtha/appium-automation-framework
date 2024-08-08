package ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    public IOSDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        String appiumServerUrl = System.getenv("APPIUM_SERVER_URL");
    
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "iOS");
        dc.setCapability("appium:automationName", "XCUITest");
        dc.setCapability("appium:app", System.getProperty("user.dir") + "/apps/UIKitCatalog.app");
        dc.setCapability("appium:deviceName", "iPhone SE (2nd generation)");
    
        driver = new IOSDriver(new URL(appiumServerUrl), dc);
    }


    @Test
    public void test(){
    System.out.println("Starting the test...");
    driver.findElement(AppiumBy.accessibilityId("Buttons")).click();
    System.out.println("Clicked the Buttons element.");
}

    @AfterTest
    public void close(){
        driver.quit();
    }
}
