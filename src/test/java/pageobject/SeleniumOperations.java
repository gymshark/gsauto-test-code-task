package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumOperations {

  WebDriver driver;
  WebDriverWait wait;

  // Constructor to initialize WebDriver and WebDriverWait
  public SeleniumOperations(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default timeout of 10 seconds
  }

  // Wait for an element to be visible
  public WebElement waitForElementToBeVisible(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  // Wait for an element to be clickable
  public WebElement waitForElementToBeClickable(By locator) {
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
  }



  }
