package driver;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import testrail.TestRailManager;

/**
 *
 * @author Ibrahim
 */
public class SpecialistDriver {

    public static JavascriptExecutor javascriptExecutor;
    public static WebBaseTest base;
    public static TestRailManager testrail;
    // public static String testRunId;
    public static boolean testRailReport;
    static DesiredCapabilities dc = new DesiredCapabilities();
    private static final String reportDirectory = "reports";
    private static final String reportFormat = "xml";
    private static final String testName = "Untitled";
    public static AndroidDriver<AndroidElement> driver = null;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        System.out.println("Test WebInitiSetup Started ..");
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "emulator-5556");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "sa.app.famcare.specialist_staging");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "sa.app.famcare.MainActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);

    }

    @Test
    public void start() {
        System.out.println(getClass().getName());
    }

}
