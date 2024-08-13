package newtest_java;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchSteps {


    private WebDriver driver;
    private GoogleHomePage googleHomePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.co.uk");
        googleHomePage = new GoogleHomePage(driver);
    }

    @Test

    @Given("I am on the Google UK homepage")
    public void iAmOnTheGoogleUKHomepage() {
        // Initialize the WebDriver and navigate to Google UK
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.uk");
    }

    @When("I type {string} into the search bar")
    public void i_type_into_the_search_bar(String searchTerm) {
        WebElement cookiesAcceptBtn = driver.findElement(By.id("L2AGLb"));
        cookiesAcceptBtn.click();
        WebElement searchBox = driver.findElement(By.name("btnK"));
        searchBox.sendKeys(searchTerm);
    }

    @When("I click on the \"I'm Feeling Lucky\" button")
    public void i_click_on_the_i_m_feeling_lucky_button() {
        // Find and click the "I'm Feeling Lucky" button
        WebElement luckyButton = driver.findElement(By.name("btnI"));
        luckyButton.click();
    }

    @Then("I should be redirected to a URL containing {string}")
    public void i_should_be_redirected_to_a_url_containing(String expectedTerm) {
        // Verify that the current URL contains the expected term
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedTerm.toLowerCase()),
                "URL does not contain the expected search term.");
    }
}
