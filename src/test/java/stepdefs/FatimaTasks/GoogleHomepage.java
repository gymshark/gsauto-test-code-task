package stepdefs.FatimaTasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;

import org.openqa.selenium.Keys;

public class GoogleHomepage {

    WebDriver driver;

    private static final By COOKIE_REJECT = By.id("W0wltc");
    private static final By SEARCH = By.id("APjFqb");
    private static final By FEELING_LUCKY = By.id("gbqfbb");

    public void googleHomepage(WebDriver driver) {
        this.driver = driver;
    }

    public void googleURL() {
        driver.manage().window().maximize();
        driver.get("https://www.google.co.uk/");
    }

    public void selectCookieButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(COOKIE_REJECT)).click();
    }

    public WebElement getSearch() {
       return driver.findElement(SEARCH);
    }

    public void enterGoogleIntoSearch() {
        driver.findElement(SEARCH).sendKeys("BBC news");
    }

    public void clickGoogleSearch() {
        driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
    }

    public void clickFeelingLuckyButton() {
        driver.findElement(FEELING_LUCKY).click();
    }

    public void feelingLuckySearchResults() {
        driver.findElement(SEARCH);
    }


}
