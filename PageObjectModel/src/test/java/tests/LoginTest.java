package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/*
import com.yourcompany.app.core.BaseTest;
import com.yourcompany.app.pages.HomePage;
import com.yourcompany.app.pages.LoginPage;
import com.yourcompany.app.utilities.TestConfig;
import com.yourcompany.app.utilities.WebDriverFactory;
*/

import core.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utilities.TestConfig;
import utilities.WebDriverFactory;



public class LoginTest extends BaseTest {
    private WebDriver driver;
    
    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.createWebDriver();
    }
    
    @Test
    public void testLogin() {
        driver.get(TestConfig.BASE_URL);
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(TestConfig.USERNAME);
        loginPage.enterPassword(TestConfig.PASSWORD);
        loginPage.clickLoginButton();
        
        HomePage homePage = new HomePage(driver);
        String welcomeMessage = homePage.getWelcomeMessage();
        
        // Add assertions here to validate the welcome message or other elements on the page.
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}