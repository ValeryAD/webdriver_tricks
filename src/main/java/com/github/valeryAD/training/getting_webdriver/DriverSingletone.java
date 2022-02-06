package com.github.valeryAD.training.getting_webdriver;

// writen by myself, needs to be checked

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSingletone {
  private static WebDriver instance;

  public static WebDriver getInstance(){
    if(instance == null){
      WebDriverManager.chromedriver().setup();
      instance = new ChromeDriver();
    }
    return instance;
  }

}
