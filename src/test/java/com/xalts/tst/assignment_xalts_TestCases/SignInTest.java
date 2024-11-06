package com.xalts.tst.assignment_xalts_TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xalts.test.assignment_xalts_base.BaseClass;
import com.xalts.test.assignment_xalts_pageObjects.HomePage;
import com.xalts.test.assignment_xalts_pageObjects.SignInPage;
import com.xalts.test.assignment_xalts_pageObjects.SignOutPage;
import com.xalts.test.assignment_xalts_utility_dataProvider.DataProviders;





public class SignInTest extends BaseClass {

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

    @Test(dataProvider = "signInData", dataProviderClass = DataProviders.class)
    public void signInTest(String email, String password, String type) {

        try {
            HomePage homepage = new HomePage(getDriver());
            homepage.clickOngetStartedBtn();  // Navigate to Sign In page
            homepage.clickOnSignInBtn();
            
            SignOutPage signout = new SignOutPage(getDriver());

            SignInPage signInPage = new SignInPage(getDriver());
            signInPage.enterEmail(email);
            signInPage.enterPassword(password);
        
            // Check if the "Sign In" button is enabled
            boolean isSignInBtnEnabled = signInPage.isSignInBtnEnabled();

            if (type.equals("positive")) {
               
                softAssert.assertTrue(isSignInBtnEnabled, "'Sign In' button should be enabled for valid credentials.");

                if (isSignInBtnEnabled) {
                    signInPage.clickSignInBtn();  // Click Sign In button

                    // After successful sign in, check if "Sign Out" button is visible
                    boolean isSignOutBtnVisible = signout.isSignOutBtnVisible();
                    softAssert.assertTrue(isSignOutBtnVisible, "'Sign Out' button should be visible after successful sign-in.");

                    if (isSignOutBtnVisible) {
                        System.out.println("Sign In successful! 'Sign Out' button is visible.");
                    }
                }

            } else {
               
                softAssert.assertFalse(isSignInBtnEnabled, "'Sign In' button should be disabled for invalid credentials.");
                
                if (!isSignInBtnEnabled) {
                    System.out.println("Sign In Unsuccessful! 'Sign In' button is disabled or not clickable.");
                }
            }

        } catch (Exception e) {
            System.out.println("An error occurred during the sign-in test: " + e.getMessage());
            softAssert.fail("Test failed due to an exception: " + e.getMessage());
        } finally {
            softAssert.assertAll();  
        }
    }
}
    
