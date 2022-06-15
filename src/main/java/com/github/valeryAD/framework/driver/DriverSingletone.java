package com.github.valeryAD.framework.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

// writen by myself, needs to be checked
//Here I use a driver manager to get chrome driver

public class DriverSingletone {
  private static WebDriver instance;

  public static WebDriver getInstance(){
    if(instance == null){
      WebDriverManager.chromedriver().setup();
      //ChromeOptions chromeOptions = new ChromeOptions();
      //chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
      instance = new ChromeDriver();
    }
    return instance;
  }

}
