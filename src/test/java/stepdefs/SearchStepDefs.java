package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.GoogleHomePage;

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

    GoogleHomePage googleHomePage = new GoogleHomePage(driver);
    googleHomePage.cookieButton_search();
    googleHomePage.textbox_element();
    GoogleHomePage.textBox_search(driver).sendKeys(searchItem);
    googleHomePage.googleButton_search();

  }

  @When("I enter {string} in lucky search term")
  public void iEnterInLuckySearchTerm(String searchItem) {

    GoogleHomePage googleHomePage = new GoogleHomePage(driver);
    googleHomePage.cookieButton_search();
    googleHomePage.textbox_element();
    GoogleHomePage.textBox_search(driver).sendKeys(searchItem);
    googleHomePage.luckyButton_search();
  }

  @Then("results relevant to the search term are returned")
  public void resultsRelevantToTheSearchTermAreReturned() {

    // Then the browser should redirect to a URL containing "BBC"
    assertThat(driver.getCurrentUrl()).as("...").contains("BBC");
  }

  @Then("results to the lucky click are returned")
  public void resultsToTheLuckyClickAreReturned() {

    // Then the browser should redirect to a URL containing "BBC"
    assertThat(driver.getCurrentUrl()).as("...").contains("bbc");

    }
  }


