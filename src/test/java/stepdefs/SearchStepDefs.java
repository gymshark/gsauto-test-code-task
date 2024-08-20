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

  @Then("I should be redirected to a URL containing {string}")
  public void i_should_be_redirected_to_a_url_containing(String expectedTerm) {
   googlesearch.getCurrentURL();
  }
}
