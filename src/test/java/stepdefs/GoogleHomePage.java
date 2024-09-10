package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // locators
    private By cookiesAcceptBtn = By.id("L2AGLb");
    private By searchBox = By.id("APjFqb");
    private By iAmFeelingLucky = By.name("btnI");

    // constructor
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
// methods

    public void acceptCookies() {
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(cookiesAcceptBtn));
        acceptButton.click();
    }

    public void searchFor(String searchTerm) {
        enterSearch(searchTerm + Keys.ENTER);
    }

    public void clickImFeelingLucky() {
        WebElement luckyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(iAmFeelingLucky));
        luckyButton.click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void enterSearch(String searchTerm) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchField.sendKeys(searchTerm);
    }
}