package com.xalts.test.assignment_xalts_pageObjects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xalts.test.assignment_xalts_actionDriver.Action;





public class SignInPage {
    WebDriver driver;
    Action action = new Action();

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='App']//div[1]//div[1]//input[1]") 
    WebElement emailTxt;

    @FindBy(xpath = "//div[@class='App']//div[2]//div[2]//input[1]") 
    WebElement passwordTxt;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement signInBtn;

    public void enterEmail(String email) {  
        action.sendKeys(driver, emailTxt, email);   
    }

    public void enterPassword(String password) {      
        action.sendKeys(driver, passwordTxt, password);  
    }

    public void clickSignInBtn() {   
        action.click(driver, signInBtn);    
    }
    
    public boolean isSignInBtnEnabled() {
        return signInBtn.isEnabled(); 
    }
    
}