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




public class SignOutTest extends BaseClass {

	  SoftAssert softAssert = new SoftAssert();

	    @Parameters("browser")
	    @BeforeMethod
	    public void setUp(String browsername) {
	        launchBrowser(browsername);
	    }

	    @AfterMethod
	    protected void tearDown() {
	      getDriver().quit(); // Close the browser after each test
	    }


    @Parameters("browser")
    @Test(dataProvider = "signOutData", dataProviderClass = DataProviders.class)
    public void signOutTest(String email, String password) {
       
    
        try {
        	
        	
            HomePage homepage = new HomePage(getDriver());
            homepage.clickOngetStartedBtn();  
            homepage.clickOnSignInBtn();

            SignInPage signInPage = new SignInPage(getDriver());
            signInPage.enterEmail(email);
            signInPage.enterPassword(password);
            signInPage.clickSignInBtn();

            SignOutPage signOutPage = new SignOutPage(getDriver());
            signOutPage.clickOnsignOutBtn();
            

        } catch (Exception e) {
            System.out.println("An error occurred during the sign-out test: " + e.getMessage());
            softAssert.fail("Test failed due to an exception: " + e.getMessage());
        } finally {
            softAssert.assertAll();  
        }
    }
}