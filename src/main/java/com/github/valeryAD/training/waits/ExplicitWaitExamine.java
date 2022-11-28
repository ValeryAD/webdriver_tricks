package com.github.valeryAD.training.waits;

import com.github.valeryAD.framework.driver.DriverSingletone;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExamine {
    private static final By BY_SEARCH_SUGGESTIONS = By.cssSelector("li.sbct");
    private static WebDriver driver;
    private static WebDriverWait wait;

    static {
        driver = DriverSingletone.getInstance();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Implicit waits (General timeouts):
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
    }

    public static void main(String[] args) {
        String searchTerm = "Java";
        String googlHomePage = "https://www.google.com/";


        driver.get(googlHomePage);
        WebElement searchField = getElement(By.name("q"));
        searchField.sendKeys(searchTerm);

        //Explicit wait:
        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).click();

        driver.get(googlHomePage);
        getElement(By.name("q")).sendKeys("Selenium");

        //Explicit wait with custom condition (lambda + function):
//        wait.until(driver -> driver.findElements(BY_SEARCH_SUGGESTIONS).stream().anyMatch(element -> !element.getText().isEmpty()));

        //Explicit wait with Custom condition, stored in separate class:
//        wait.until(CustomConditions.listOfElementsContainsValues(BY_SEARCH_SUGGESTIONS));
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Fluent wait with custom condition:
        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class);
        wait1.until(CustomConditions.listOfElementsContainsValues(BY_SEARCH_SUGGESTIONS));
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<String> suggestions = driver.findElements(BY_SEARCH_SUGGESTIONS).stream()
                .map(WebElement::getText)
                .filter(item -> !item.isBlank())
                .collect(Collectors.toList());


        System.out.println("Search suggestions:");
        suggestions.forEach(System.out::println);

        driver.quit();
    }


    public static WebElement getElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


}