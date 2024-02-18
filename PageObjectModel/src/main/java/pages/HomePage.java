package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    By welcomeMessage = By.id("welcomeMessage");
    
    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }
}

