package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobject.GoogleHomePage;
import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefs {
  public WebDriver driver;

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

  @Given("^I am on the Google UK$")
  public void iAmOnTheGoogleUk() {
    driver.manage().window().maximize();
    driver.get("https://www.google.co.uk");
  }
  @When("I enter {string} search term")
  public void iEnterSearchTerm(String searchItem) {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    GoogleHomePage.CookiesButton_search(driver).click();
    GoogleHomePage.textBox_search(driver).sendKeys(searchItem);
    //wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).sendKeys(Keys.ENTER);
    wait.until(ExpectedConditions.elementToBeClickable(GoogleHomePage.GoogleButton_search(driver))).sendKeys(Keys.ENTER);
    GoogleHomePage.GoogleButton_search(driver).click();

  }

  @When("I enter {string} in lucky search term")
  public void iEnterInLuckySearchTerm(String searchItem) {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    GoogleHomePage.CookiesButton_search(driver).click();
    GoogleHomePage.textBox_search(driver).sendKeys(searchItem);
    //wait.until(ExpectedConditions.elementToBeClickable(By.name("btnI"))).sendKeys(Keys.ENTER);
    wait.until(ExpectedConditions.elementToBeClickable(GoogleHomePage.LuckyButton_search(driver))).sendKeys(Keys.ENTER);
    GoogleHomePage.LuckyButton_search(driver).click();
  }

  @Then("results relevant to the search term are returned")
  public void resultsRelevantToTheSearchTermAreReturned() {
   List<WebElement> resultHeaders = driver.findElements(By.xpath("//a/h3"));
   for (WebElement header : resultHeaders) {
     assertThat(header.getText()).as("Search results contains search term").contains("BBC");
    }}


  @Then("results to the lucky click are returned")
  public void resultsToTheLuckyClickAreReturned() {
    List<WebElement> resultHeaders = driver.findElements(By.xpath("//a/h3"));
    for (WebElement header : resultHeaders) {
      assertThat(header.getText()).as("Search results contains search term").contains("BBC");
    }
  }
}
