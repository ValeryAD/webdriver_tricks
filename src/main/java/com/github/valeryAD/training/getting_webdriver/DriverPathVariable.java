package com.github.valeryAD.training.getting_webdriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverPathVariable {
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//You should download driver and add to environment variable 'path' directory, where the chromedriver is located
// e.g. C:\webdriver
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

  public static void main(String[] args) {
   WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com/");

    System.out.println(driver.getCurrentUrl());
    WebElement searchField = driver.findElement(By.name("q"));
    searchField.sendKeys("Launch chromedriver");
      System.out.println(searchField.getText());
      new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).click();


    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    driver.quit();
  }
}
