package com.xalts.test.assignment_xalts_actionDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.xalts.test.assignment_xalts_action_Interface.ActionInterface;


public class Action implements ActionInterface {

    @Override
    public void click(WebDriver driver, WebElement element) {
        element.click();
    }

    @Override
    public boolean isDisplayed(WebDriver driver, WebElement element) {
        return element.isDisplayed();
    }

    @Override
    public void sendKeys(WebDriver driver, WebElement element, String value) {
        element.sendKeys(value);
    }
}