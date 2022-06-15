package com.github.valeryAD.training.getting_webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPathVariable {
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//You should download driver and add to environment variable 'path' directory, where the chromedriver is located
// e.g. C:\webdriver
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

  public static void main(String[] args) {
   WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com/");

    System.out.println(driver.getCurrentUrl());

    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    driver.close();
  }
}
