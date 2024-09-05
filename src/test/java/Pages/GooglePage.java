package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GooglePage {

    private static final By REJECT_ALL = By.id("W0wltc");

    private static final By SEARCH_FIELD = By.id("APjFqb");
    private static final By SEARCH_RESULTS = By.xpath("//a/h3");
    private static final By FEELING_LUCKY = By.id("gbqfbb");
    //redirected to url that contains search term
    private WebDriver driver;


    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void navigateToGoogle() {
        driver.manage().window().maximize();
        driver.get("https://www.google.co.uk/");

    }


    public void selectRejectAll() {
        waitForElementToBeClickable((WebElement) REJECT_ALL);
        driver.findElement(REJECT_ALL).click();

    }

    public WebElement getSearch() {
        return driver.findElement(SEARCH_FIELD);
    }

    public void enterSearchTerm() {
        driver.findElement(SEARCH_FIELD).sendKeys("BBC news");
    }

    public void clickGoogleSearch() {
        driver.findElement(SEARCH_FIELD).sendKeys(Keys.ENTER);
    }

    public void displaySearchResults() {
        List<WebElement> resultHeaders = driver.findElements(SEARCH_RESULTS);
        for (WebElement header : resultHeaders) {
            assertThat(header.getText()).as("Search results contains search term").contains("BBC");
        }
    }

    public void tapFeelingLuckyButton() {
        //  waitForElementToBeClickable((Locator) FEELING_LUCKY);
        driver.findElement(FEELING_LUCKY).click();

    }

    public void feelingLuckySearchResults() {
        String url = driver.getCurrentUrl();
        assertThat(url).contains(String.valueOf(getSearch().getText()));
    }

}
