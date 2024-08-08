package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleHomePage {

  public WebDriver driver;
  public GoogleHomePage(WebDriver driver) {
    this.driver = driver;
  }

  public static WebElement textBox_search(WebDriver driver) {
    return driver.findElement(By.name("q"));
  }

  public static WebElement GoogleButton_search(WebDriver driver) {
    return driver.findElement(By.name("btnK"));

  }

  public static WebElement LuckyButton_search(WebDriver driver) {
    return driver.findElement(By.name("btnI"));

  }

  public static WebElement CookiesButton_search(WebDriver driver) {
    return driver.findElement(By.id("L2AGLb"));
  }
}
