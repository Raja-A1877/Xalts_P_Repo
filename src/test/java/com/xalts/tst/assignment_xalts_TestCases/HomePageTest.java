package com.xalts.tst.assignment_xalts_TestCases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xalts.test.assignment_xalts_base.BaseClass;
import com.xalts.test.assignment_xalts_pageObjects.HomePage;



public class HomePageTest extends BaseClass {

	
	 @Parameters("browser")
	    @BeforeMethod
	    public void setUp(String browsername) {
	        launchBrowser(browsername);
	    }

	    @AfterMethod
	    protected void tearDown() {
	      getDriver().quit(); 
	    }
	    
    @Test()
    public void homePageTest() {
       
        
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOngetStartedBtn();
       
        SoftAssert softAssert = new SoftAssert();
        
       
        softAssert.assertAll();
    }
}