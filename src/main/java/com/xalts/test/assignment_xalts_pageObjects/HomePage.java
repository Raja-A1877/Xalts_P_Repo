package com.xalts.test.assignment_xalts_pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xalts.test.assignment_xalts_actionDriver.Action;



public class HomePage {
  
	WebDriver driver;
    Action action = new Action();

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /* Declaration*/
    
    @FindBy(xpath = "//button[normalize-space()='Get Started']")
    WebElement getStartedBtn;

    @FindBy(xpath = "//button[normalize-space()='Already have an account? Click here to sign in.']")
    WebElement hmSignInBtn;

 

    /*Utilization */
    
    public void clickOngetStartedBtn() { 
        action.click(driver, getStartedBtn);
    }

    public void clickOnSignInBtn() { 
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hmSignInBtn);
        action.click(driver, hmSignInBtn);
    }
    
    
    
}