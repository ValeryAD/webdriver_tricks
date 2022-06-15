package com.github.valeryAD.training.waits;

import com.github.valeryAD.framework.driver.DriverSingletone;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExamine {
  private static WebDriver driver;

  public static void main(String[] args) {
    String searchString = "Hello World!";
    driver = DriverSingletone.getInstance();
    driver.get("https://www.google.com/");
    WebElement searchField = getElement(By.name("q"));
    searchField.sendKeys(searchString);
    //searchField.sendKeys(Keys.ENTER);
    WebElement firstSearchResult = new WebDriverWait(driver, Duration.ofSeconds(7)).until(
        ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[@data-view-type and @role='presentation'][1]")));
        firstSearchResult.click();
  }

  public static WebElement getElement(By by){
    return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(by));
  }

}
