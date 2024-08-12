package stepdefs.FatimaTasks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefs {
    private WebDriver driver;
    GoogleHomepage google = new GoogleHomepage();


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
        google.googleHomepage(driver);
        google.googleURL();
    }

    @When("I enter a search term eg 'BBC'")
    public void iEnterASearchTerm() {
        google.selectCookieButton();
        google.enterGoogleIntoSearch();
        google.clickGoogleSearch();
    }

    @Then("results relevant to the search term are returned")
    public void resultsRelevantToTheSearchTermAreReturned() {
        List<WebElement> resultHeaders = driver.findElements(By.xpath("//a/h3"));
        for (WebElement header : resultHeaders) {
            assertThat(header.getText()).as("Search results contains search term").contains("BBC");
        }
    }

    @When("I click on I'm Feeling Lucky")
    public void clickOnImFeelingLucky() {
        google.selectCookieButton();
        google.clickFeelingLuckyButton();

    }

    @Then("the url will reflect the search term")
    public void verifyURLHasSearchTerm() {
        String currentURL = driver.getCurrentUrl();
        assertThat(currentURL).contains(String.valueOf(google.getSearch().getText()));
    }
}
