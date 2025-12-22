package com.qa.orangehrm.basetest;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.orangehrm.appconstants.I_ApplicationConstantValues;
import com.qa.orangehrm.diverfactory.DriverManager;
import com.qa.orangehrm.pagelayers.AdminPage;
import com.qa.orangehrm.pagelayers.DashboardPage;
import com.qa.orangehrm.pagelayers.LoginPage;
import com.qa.orangehrm.pagelayers.PIM_Page;
import com.qa.orangehrm.utilities.BrowserUtility;

//@Listeners(ChainTestListener.class)
public class BaseTest {
	private WebDriver driver;
	DriverManager dm;
	protected LoginPage lp;
	protected DashboardPage dbp;
	protected AdminPage ap;
	protected Properties prop;
	protected PIM_Page pim;
	BrowserUtility bu;
	private static final  Logger  log =  LogManager.getLogger(BaseTest.class);
	@Parameters("xmlBrowserName")//xml-Firefox
	@BeforeTest
	public void launchBrowser(String xmlBrowserName) throws FileNotFoundException {
		dm = new DriverManager();
		prop = dm.initProperty();
		if(xmlBrowserName!=null) {
			prop.setProperty("browserName", xmlBrowserName);
		}
		log.info("The initialized browser is :"+prop.getProperty("browserName"));
		driver = dm.browserInit(prop.getProperty("browserName"));//chrome//firefox//Ie
		bu = new BrowserUtility(driver);
		bu.maximizeBrowser();
		bu.globalWait(I_ApplicationConstantValues.MIN_WAIT_TIME);
		bu.enterUrl(prop.getProperty("testUrl"));
		lp = new LoginPage(driver);
	}
	@AfterMethod	
	public void getScreenshotFile(ITestResult result) throws InterruptedException {
		Thread.sleep(500);
		if(!result.isSuccess()) {
		ChainTestListener.embed(DriverManager.captureScreenshotFile(),"image/png");
		}
	}
	@AfterTest
	public void terminateBrowser() throws InterruptedException {
	if (driver != null) {
		Thread.sleep(2000);
		try {
			dbp.logoutApplication();
		} catch (Exception e) {
			log.info("[BaseTest]-Already logged out from application");
		}
//	Thread.sleep(2000);
	bu.terminateBrowser();
	    }
	   }	
}
