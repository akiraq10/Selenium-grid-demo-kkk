import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Webdriver {
    public static WebDriver getChromeDriver() throws MalformedURLException {

//        String path = System.getProperty("user.dir");
//        String chromeDriverPath= path +"/src/com.test.test/resources/chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        WebDriverManager.chromedriver().setup();
//        return new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");

        return new RemoteWebDriver(new URL("http://localhost:4444/"),
                capabilities);

    }
}
