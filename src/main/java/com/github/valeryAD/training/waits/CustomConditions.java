package com.github.valeryAD.training.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {

    public static ExpectedCondition<Boolean> listOfElementsContainsValues(By listLocator) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElements(listLocator).stream().anyMatch(element -> !element.getText().isEmpty());
            }
        };
    }
}
