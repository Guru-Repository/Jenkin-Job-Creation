package com.qa.orangehrm.diverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.qa.orangehrm.appconstants.I_ApplicationConstantValues;
import com.qa.orangehrm.apperrormsg.ApplicationErrorMsg;
import com.qa.orangehrmexceptions.FrameworkExceptions;

public class DriverManager {
	private BrowserOptions bopts;
	private Properties prop;
	private static final  Logger  log =  LogManager.getLogger(DriverManager.class);
	public static ThreadLocal<WebDriver> ltDriver = new ThreadLocal<WebDriver>();
	public WebDriver browserInit(String browserName)
	{
		log.info("From class [DriverManager] & method [browserInit] The initialized browser is :"+browserName);
		switch(browserName.toLowerCase().trim()){
			case"chrome":
				ltDriver.set(new ChromeDriver(bopts.getChromeOptions()));
				break;
			case"firefox":
				ltDriver.set(new FirefoxDriver(bopts.getFirefoxOptions()));
				break;
			case"edge":
				ltDriver.set(new EdgeDriver(bopts.getEdgeOptions()));
				break;
			case"ie":
				ltDriver.set(new InternetExplorerDriver(bopts.getIEOptions()));
				break;
			case"safari":
				ltDriver.set(new SafariDriver());
				break;
			default:System.out.println(ApplicationErrorMsg.INVALID_BROWSER_MSG);
					throw new FrameworkExceptions("===Invalid Browsername===");
		}
		return getDriver();
	}
	
	public static WebDriver getDriver() {
		log.info("From class [DriverManager] & method [getDriver] The localdriver has been returned");
		return ltDriver.get();
	}
	
	
	
	public Properties initProperty() {
		try {
			FileInputStream fis = new FileInputStream(I_ApplicationConstantValues.PROPERTYFILEPATH);
			prop = new Properties();
			prop.load(fis);
			bopts = new BrowserOptions(prop);
			log.info("From class [DriverManager] & method [initProperty] The porperty file  has been initialized with proper location");
			}
		catch (Exception e) {
			log.info("From class [DriverManager] & method [initProperty] The porperty file  is not initialized");
			throw new FrameworkExceptions("===[DriverManager] - Could not initiate the property file / incorrect file path===");
		}
		log.info("From class [DriverManager] & method [initProperty] The porperty file  is initialized and returned");
		return prop;		
	}
	
	public static File captureScreenshotFile() {
		TakesScreenshot ts = (TakesScreenshot)getDriver();
		log.info("From class [DriverManager] & method [captureScreenshotFile] The screenshot has initialized and returned");
		return ts.getScreenshotAs(OutputType.FILE);
	}
}












