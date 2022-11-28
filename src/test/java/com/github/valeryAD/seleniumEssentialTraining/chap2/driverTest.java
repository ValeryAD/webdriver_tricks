package com.github.valeryAD.seleniumEssentialTraining.chap2;

import com.github.valeryAD.framework.driver.DriverSingletone;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class driverTest {
  @Test
  public void openCloseDriverTest() {
    System.out.println("User!:" + System.getProperty("mainUser"));
    WebDriver driver = DriverSingletone.getInstance();
    driver.get("https://formy-project.herokuapp.com/");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    DriverSingletone.quit();

    driver = DriverSingletone.getInstance();
    driver.get("https://formy-project.herokuapp.com/");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.close();
    {int i = 5;}


  }

}
