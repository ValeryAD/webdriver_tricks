package com.github.valeryAD.seleniumEssentialTraining.chap2;

import com.github.valeryAD.framework.screens.formy.HomeScreen;
import com.github.valeryAD.seleniumEssentialTraining.BaseTestFormy;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ActionsWithElements extends BaseTestFormy {

  HomeScreen homeScreen;

  @BeforeMethod
  private void initVariables(){
    homeScreen = new HomeScreen();
  }

  @Test
  public void keyboardTest() throws InterruptedException {
    homeScreen.clickKeyAndMousePressLink();
    final String NAME = "Chuck Norris";
    WebElement nameInput = driver.findElement(By.id("name"));
    nameInput.click();
    nameInput.sendKeys(NAME);
    WebElement button = driver.findElement(By.id("button"));
    button.click();
    TimeUnit.SECONDS.sleep(2);
  }

  @Test
  public void scrollTest() throws InterruptedException {
    homeScreen.clickPageScrollLink();
    Actions actions = new Actions(driver);
    WebElement nameInput = driver.findElement(By.id("name"));
    WebElement dateInput = driver.findElement(By.id("date"));
    actions.moveToElement(nameInput);
    nameInput.click();
    nameInput.sendKeys("Kira Daroshka");
    dateInput.sendKeys("07/01/08");
    TimeUnit.SECONDS.sleep(2);
  }

  @Test
  public void switchWindowTest() throws InterruptedException {
    homeScreen.clickSwitchWindowLink();
    WebElement openNewTabButton = driver.findElement(By.id("new-tab-button"));
    openNewTabButton.click();
    String originalHandle = driver.getWindowHandle();
    for(String handle : driver.getWindowHandles()){
      driver.switchTo().window(handle);
      System.out.println(String.format("current handle: %s", handle));
      TimeUnit.SECONDS.sleep(2);
    }
    driver.switchTo().window(originalHandle);
    TimeUnit.SECONDS.sleep(2);
  }

  @Test
  public void dragAndDropTest() throws InterruptedException {
    homeScreen.clickDragAndDropLink();
    WebElement image = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.id("image")));
    WebElement box = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.id("box")));
//using class Actions    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Actions actions = new Actions(driver);
    //actions.dragAndDrop(image, box).build().perform();
//using JavaScript+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//    JavascriptExecutor js = (JavascriptExecutor)driver;
//    js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
//        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
//        + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
//        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
//        + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
//        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
//        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
//        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
//        + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
//        + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
//        + "var dropEvent = createEvent('drop');\n"
//        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
//        + "var dragEndEvent = createEvent('dragend');\n"
//        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
//        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
//        + "simulateHTML5DragAndDrop(source,destination);", image, box);
    TimeUnit.SECONDS.sleep(3);
  }
}
