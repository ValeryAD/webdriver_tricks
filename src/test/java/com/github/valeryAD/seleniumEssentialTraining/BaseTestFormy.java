package com.github.valeryAD.seleniumEssentialTraining;

import com.github.valeryAD.framework.driver.DriverSingletone;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTestFormy {

  protected WebDriver driver;

  @BeforeMethod
  public void init() {
    driver = DriverSingletone.getInstance();
    driver.get("https://formy-project.herokuapp.com/");
  }

  @AfterMethod
  public void closeBrowser() {
    DriverSingletone.quit();
  }

}
