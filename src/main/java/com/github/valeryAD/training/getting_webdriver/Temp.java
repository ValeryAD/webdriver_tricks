package com.github.valeryAD.training.getting_webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Temp {

  public static void main(String[] args) {
    //System.setProperty("webdriver.chrome.driver", "C:\\wdriver\\chromedriver!.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.close();
  }

}
