package com.xalts.test.assignment_xalts_pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xalts.test.assignment_xalts_actionDriver.Action;



public class SignOutPage {
  
	WebDriver driver;
    Action action = new Action();

    public SignOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

  
    @FindBy(xpath = "//button[normalize-space()='Sign Out']") 
    WebElement signOutBtn;
    
    

    public void clickOnsignOutBtn() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        wait.until(ExpectedConditions.visibilityOf(signOutBtn));
        action.click(driver, signOutBtn);
    }
        
    public boolean isSignOutBtnVisible() {	        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        wait.until(ExpectedConditions.visibilityOf(signOutBtn));
        return signOutBtn.isDisplayed();}
        	    
    }
