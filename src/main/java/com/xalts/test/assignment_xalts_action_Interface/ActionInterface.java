package com.xalts.test.assignment_xalts_action_Interface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	
public interface ActionInterface {
   
	void click(WebDriver driver, WebElement element);
    boolean isDisplayed(WebDriver driver, WebElement element);
    void sendKeys(WebDriver driver, WebElement element, String value);

}