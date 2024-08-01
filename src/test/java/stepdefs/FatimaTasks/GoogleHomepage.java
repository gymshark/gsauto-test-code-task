package stepdefs.FatimaTasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;

public class GoogleHomepage {

    WebDriver driver;

    public void googleHomepage(WebDriver driver) {
        this.driver = driver;
    }

    public void googleURL() {
        driver.manage().window().maximize();
        driver.get("https://www.google.co.uk/");
    }

    public void selectCookieButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("W0wltc"))).click();
    }


}
