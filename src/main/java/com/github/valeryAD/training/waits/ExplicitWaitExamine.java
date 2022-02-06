package com.github.valeryAD.training.waits;

import com.github.valeryAD.training.getting_webdriver.DriverSingletone;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExamine {

  public static void main(String[] args) {
    String searchString = "Hello World!";
    WebDriver driver = DriverSingletone.getInstance();
    driver.get("http://google.com");
    WebElement searchField = driver.findElement(By.name("q"));
    searchField.sendKeys(searchString);

    driver.findElement(By.xpath("//ul/li[@data-view-type and @role='presentation'][1]")).click();
  }

}
