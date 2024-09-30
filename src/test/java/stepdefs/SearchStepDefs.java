package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.SearchPage;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefs {
  private WebDriver driver;

  @Before
  public void setup() {
    driver = Setup.setupAndGetDriver();
  }

  @After
  public void teardown() {
    driver.quit();
  }

  @Given("^I am on the Google UK homepage$")
  public void iAmOnTheGoogleUkHomepage() {
    driver.manage().window().maximize();
    driver.get("https://www.google.co.uk");
  }
  
  @When("I enter a {string}")
  public void iEnterA(String string) {
    WebElement acceptAll = driver.findElement(SearchPage.ACCEPT_ALL);
    acceptAll.sendKeys(Keys.ENTER);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(SearchPage.SEARCH_BUTTON));
    searchButton.click();
  }

  @When("entered a search term and clicked on I am Feeling Lucky")
  public void enteredASearchTermAndClickedOnIAmFeelingLucky() {
    WebElement acceptAll = driver.findElement(SearchPage.ACCEPT_ALL);
    acceptAll.sendKeys(Keys.ENTER);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(SearchPage.SEARCH_BUTTON));
    searchButton.click();
    searchButton.sendKeys("BBC");

    Actions action = new Actions(driver);
    WebElement luckyButton = driver.findElement(SearchPage.FEELING_LUCKY);
    action.moveToElement(luckyButton).click().perform();
  }

  @Then("results relevant to the search term are returned")
  public void resultsRelevantToTheSearchTermAreReturned() {
    List<WebElement> resultHeaders = driver.findElements(SearchPage.RESULT_HEADERS);
    for(WebElement header : resultHeaders) {
      assertThat(header.getText()).as("Search results contains search term").contains("BBC");
    }
  }

  @Then("navigated to the relavant URL to the search entered")
  public void navigatedToTheRelavantUrlToTheSearchEntered() {
    driver.switchTo().newWindow(WindowType.TAB);
    driver.getCurrentUrl().contains("bbc");
  }
}
