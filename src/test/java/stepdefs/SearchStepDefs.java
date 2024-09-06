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

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefs {
  private WebDriver driver;
  private GoogleHomePage googlesearch;

  @Before
  public void setup() {
    driver = Setup.setupAndGetDriver();
    googlesearch = new GoogleHomePage(driver); // initilize GoogleHomepage with driver
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

  @When("I type {string} into the search bar")
  public void i_type_into_the_search_bar(String searchTerm) {
    googlesearch.searchFor(searchTerm);
  }

  @When("I click on the \"I'm Feeling Lucky\" button")
  public void i_click_on_the_i_m_feeling_lucky_button() {
    googlesearch.clickImFeelingLucky();
  }

  @When("I enter a search term")
  public void iEnterASearchTerm() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='L2AGLb2']"))).click();
    driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("BBC news");
    driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
  }

  @Then("I should be redirected to a URL containing {string}")
  public void i_should_be_redirected_to_a_url_containing(String expectedTerm) {
   googlesearch.getCurrentURL();
  }

  @Then("results relevant to the search term are returned")
  public void resultsRelevantToTheSearchTermAreReturned() {
    List<WebElement> resultHeaders = driver.findElements(By.xpath("//a/h3"));
    for(WebElement header : resultHeaders) {
      assertThat(header.getText()).as("Search results contains search term").contains("BBC");
    }
  }
}
