package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GoogleHomePage {

  By textBox = By.name("q");
  By luckyButton = By.name("btnI");
  By googleButton = By.name("btnK");
  By cookieButton = By.id("L2AGLb");

  public WebDriver driver;
  SeleniumOperations seleniumOperations;

  public GoogleHomePage(WebDriver driver) {
    this.driver = driver;
    this.seleniumOperations = new SeleniumOperations(driver);
  }

  public void googleButton_search() {
    seleniumOperations.waitForElementToBeVisible(googleButton);
    seleniumOperations.waitForElementToBeClickable(googleButton).sendKeys(Keys.ENTER);
  }

  public void luckyButton_search() {
    seleniumOperations.waitForElementToBeVisible(luckyButton);
    seleniumOperations.waitForElementToBeClickable(luckyButton).sendKeys(Keys.ENTER);
    seleniumOperations.waitForElementToBeClickable(luckyButton).click();
  }

  public void cookieButton_search() {
    seleniumOperations.waitForElementToBeVisible(cookieButton);
    seleniumOperations.waitForElementToBeClickable(cookieButton).sendKeys(Keys.ENTER);
  }

  public void textbox_element() {
    seleniumOperations.waitForElementToBeVisible(textBox);
  }

  public static WebElement textBox_search(WebDriver driver) {
    return driver.findElement(By.name("q"));
  }
}

