package com.github.valeryAD.framework.listeners;

import com.github.valeryAD.framework.driver.DriverSingletone;
import org.openqa.selenium.WebDriver;
import org.testng.IClassListener;
import org.testng.ITestClass;

public class OpenCloseBrowserEachClassListener implements IClassListener {

  @Override
  public void onBeforeClass(ITestClass testClass) {
    DriverSingletone.getInstance().get("");
  }

  @Override
  public void onAfterClass(ITestClass testClass) {
   DriverSingletone.getInstance().close();
  }


}
