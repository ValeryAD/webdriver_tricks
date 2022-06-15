package com.github.valeryAD.training.getting_webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//Driver is stored directly in project
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class DriverInProject {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
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
