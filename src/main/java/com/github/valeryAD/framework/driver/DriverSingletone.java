package com.github.valeryAD.framework.driver;

import com.github.valeryAD.framework.listeners.OpenCloseBrowserEachClassListener;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

// writen by myself, needs to be checked
//Here I use a driver manager to get chrome driver

public class DriverSingletone {
  private static ThreadLocal<WebDriver> instance = new ThreadLocal<>();

  public static synchronized WebDriver getInstance(){
    if(instance.get() == null){
      WebDriverManager.chromedriver().setup();
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
      WebDriver driver = new ChromeDriver(chromeOptions);
      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
      driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      instance.set(driver);
    }
    return instance.get();
  }

  public static synchronized void quit(){
    instance.get().quit();
    instance.remove();
  }


}
