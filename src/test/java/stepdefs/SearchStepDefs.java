package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import pageobjects.SearchPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefs {
  private WebDriver driver;
  SearchPage googleSearch = new SearchPage();


  @Before
  public void setup() {
    driver = Setup.setupAndGetDriver();
  }

  @After
  public void teardown() {
    driver.quit();
  }

  private String allSearchTerm;
  @Given("^I am on the Google UK homepage$")
  public void iAmOnTheGoogleUkHomepage() {
    googleSearch.SearchPage(driver);
    googleSearch.googleURL();
  }
  
  @When("I enter a {string}")
  public void iEnterA(String searchTerm) {
    allSearchTerm = searchTerm;
    googleSearch.setAcceptAll();
    googleSearch.searchTerm(searchTerm);
  }

  @When("entered a search term and clicked on I am Feeling Lucky")
  public void enteredASearchTermAndClickedOnIAmFeelingLucky() {
    googleSearch.setAcceptAll();
    String searchText = "BBC";
    googleSearch.luckySearchTerm(searchText);
    googleSearch.clickImFeelingLucky();
  }

  @Then("results relevant to the search term are returned")
  public void resultsRelevantToTheSearchTermAreReturned() {
    List<WebElement> resultHeaders = googleSearch.getResultHeaders();
    for(WebElement header : resultHeaders) {
      assertThat(header.getText()).as("Search results contains search term").containsIgnoringCase(allSearchTerm);
    }
  }

  @Then("navigated to the relavant URL to the search entered")
  public void navigatedToTheRelavantUrlToTheSearchEntered() {
    String currentUrl = driver.getCurrentUrl();
    assertThat(currentUrl).as("Search results contains search term").contains("bbc");
  }
}
