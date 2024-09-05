package stepdefs;

import Pages.GooglePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SearchStepDefs {

    GooglePage google = new GooglePage();
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
        google.navigateToGoogle();
        google.selectRejectAll();
    }

    @When("^I enter a search term \"BBC news\"$")
    public void iEnterASearchTerm() {
        google.getSearch();
        google.enterSearchTerm();
        google.clickGoogleSearch();
    }

    @Then("^results relevant to the search term are returned$")
    public void resultsRelevantToTheSearchTermAreReturned() {
        google.displaySearchResults();
        google.navigateToGoogle();
    }

    @When("I tap on Feeling lucky button")
    public void tapFeelingLuckyButton() {
        google.tapFeelingLuckyButton();
    }

    @Then("Browser redirects to URL containing search term")
    public void feelingLuckySearchResults() {
        google.feelingLuckySearchResults();

    }

}