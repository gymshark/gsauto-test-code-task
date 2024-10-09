package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class SearchPage {
  public static final By ACCEPT_ALL = By.id("L2AGLb");
  public static final By SEARCH_BUTTON = By.id("APjFqb");
  public static final By RESULT_HEADERS = By.xpath("//a/h3");
  public static final By FEELING_LUCKY = By.name("btnI");
  private WebDriver driver;
  private WebDriverWait wait;


  public void SearchPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  }

  public void googleURL() {
    driver.manage().window().maximize();
    driver.get("https://www.google.co.uk/");
  }

  public void setAcceptAll(){
    wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_ALL)).click();
  }

  public void searchTerm(String searchTerm) {
    WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON));
    searchField.sendKeys(searchTerm);
    searchField.sendKeys(Keys.ENTER);
  }

  public void luckySearchTerm(String searchTerm) {
    WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON));
    searchField.sendKeys(searchTerm);
  }

  public void clickImFeelingLucky() {
    WebElement luckyButtonElement = wait.until(ExpectedConditions.elementToBeClickable(FEELING_LUCKY));
    luckyButtonElement.click();
  }

  public List<WebElement> getResultHeaders() {
    return driver.findElements(RESULT_HEADERS);
  }
}
