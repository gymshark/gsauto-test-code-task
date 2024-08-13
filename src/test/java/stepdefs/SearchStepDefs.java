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
  
  @When("I enter a search term")
  public void iEnterASearchTerm() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement cookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb")));
    cookies.click();
    driver.findElement(By.id("APjFqb")).sendKeys("BBC news");
    driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
  }

  @Then("results relevant to the search term are returned")
  public void resultsRelevantToTheSearchTermAreReturned() {
    List<WebElement> resultHeaders = driver.findElements(By.xpath("//a/h3"));
    for(WebElement header : resultHeaders) {
      assertThat(header.getText()).as("Search results contains search term").contains("BBC");
    }
  }
}
