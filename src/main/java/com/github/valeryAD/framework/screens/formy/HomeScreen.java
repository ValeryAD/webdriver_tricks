package com.github.valeryAD.framework.screens.formy;

import com.github.valeryAD.framework.driver.DriverSingletone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen {
  public static final int STANDART_WAIT = 5;

  private WebDriver driver = DriverSingletone.getInstance();

  public HomeScreen(){
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//a[@class='btn btn-lg' and @href='/keypress']")
  private WebElement keyAndMousePressLink;

  @FindBy(xpath = "//a[@class='btn btn-lg' and @href='/scroll']")
  private WebElement pageScrollLink;

  @FindBy(xpath = "//a[@class='btn btn-lg' and @href='/switch-window']")
  private WebElement switchWindowLink;

  @FindBy(xpath = "//a[@class='btn btn-lg' and @href='/dragdrop']")
  private WebElement dragAndDropLink;

  public void clickDragAndDropLink(){
    dragAndDropLink.click();
  }

  public void clickKeyAndMousePressLink(){
    keyAndMousePressLink.click();
  }

  public void clickPageScrollLink(){
    pageScrollLink.click();
  }

  public void clickSwitchWindowLink(){
    Actions actions = new Actions(driver);
    actions.moveToElement(switchWindowLink);
    switchWindowLink.click();
  }

}
