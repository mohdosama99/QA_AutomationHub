package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver createWebDriver() {
      //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
        return driver;
    }
}
