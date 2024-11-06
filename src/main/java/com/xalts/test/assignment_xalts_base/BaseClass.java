package com.xalts.test.assignment_xalts_base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.xalts.test.assignment_xalts_utility.ExtentManager;

public class BaseClass {
	   
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Properties prop;

    @BeforeSuite()
    public void loadConfig() {
        ExtentManager.setExtent();
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/Configuration/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchBrowser(String browserName)
    {
        
    	if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
        } else {
            throw new RuntimeException("Browser type unsupported");
        }

        driver.get().manage().window().maximize();
        driver.get().manage().deleteAllCookies();
        driver.get().get(prop.getProperty("url"));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @AfterSuite()
    public void afterSuite() {
        ExtentManager.endReport();


        }
}
    