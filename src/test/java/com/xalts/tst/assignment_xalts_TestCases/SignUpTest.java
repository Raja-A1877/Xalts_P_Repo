package com.xalts.tst.assignment_xalts_TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xalts.test.assignment_xalts_base.BaseClass;
import com.xalts.test.assignment_xalts_pageObjects.HomePage;
import com.xalts.test.assignment_xalts_pageObjects.SignUpPage;
import com.xalts.test.assignment_xalts_utility_dataProvider.DataProviders;


public class SignUpTest extends BaseClass {
  
	SoftAssert softAssert = new SoftAssert();
   

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browsername) {
        launchBrowser(browsername);
    }
    
    @AfterMethod
    protected void tearDown() {
      
          getDriver().quit();
        }

    @Test(dataProvider = "signUpData", dataProviderClass = DataProviders.class)
    public void signUpTest(String email, String password, String confirmpassword, String type) {
        
        try {
            HomePage homepage = new HomePage(getDriver());
            homepage.clickOngetStartedBtn();
        
            SignUpPage signUpPage = new SignUpPage(getDriver());
            signUpPage.enterEmail(email);
            signUpPage.enterPassword(password);
            signUpPage.enterConfirmPassword(confirmpassword);

            // Check if the sign-up button is enabled or disabled
            boolean isSignUpEnabled = signUpPage.isSignUpBtnEnabled();
     

            // Perform assertions based on the type and button status
            if (type.equals("positive")) {
                softAssert.assertTrue(isSignUpEnabled, "Sign Up button should be enabled for valid credentials.");
               
                if (isSignUpEnabled) {
                    signUpPage.clickSignUpBtn(); 
                }
                
            } else {
                softAssert.assertFalse(isSignUpEnabled, "Sign Up button should be disabled for invalid credentials.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred during the sign-up test: " + e.getMessage());
            softAssert.fail("Test failed due to an exception: " + e.getMessage());
      
        } finally {
            softAssert.assertAll(); 
           
        }
    }
}