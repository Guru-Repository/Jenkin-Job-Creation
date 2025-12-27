package com.qa.orangehrm.diverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.orangehrm.apperrormsg.ApplicationErrorMsg;
import com.qa.orangehrmexceptions.FrameworkExceptions;

public class DriverManager {
	private BrowserOptions bopts;
	private Properties prop;
	private static final Logger log = LogManager.getLogger(DriverManager.class);
	public static ThreadLocal<WebDriver> ltDriver = new ThreadLocal<WebDriver>();

	public WebDriver browserInit(String browserName) {
		log.info("From class [DriverManager] & method [browserInit] The initialized browser is :" + browserName);
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			ltDriver.set(new ChromeDriver(bopts.getChromeOptions()));
			break;
		case "firefox":
			ltDriver.set(new FirefoxDriver(bopts.getFirefoxOptions()));
			break;
		case "edge":
			ltDriver.set(new EdgeDriver(bopts.getEdgeOptions()));
			break;
		case "ie":
			ltDriver.set(new InternetExplorerDriver(bopts.getIEOptions()));
			break;
		case "safari":
			ltDriver.set(new SafariDriver());
			break;
		default:
			System.out.println(ApplicationErrorMsg.INVALID_BROWSER_MSG);
			throw new FrameworkExceptions("===Invalid Browsername===");
		}
		return getDriver();
	}

	public static WebDriver getDriver() {
		log.info("From class [DriverManager] & method [getDriver] The localdriver has been returned");
		return ltDriver.get();
	}

	public Properties initProperty() {

		prop = new Properties();
		FileInputStream fis = null;
		String envName = System.getProperty("env").trim().toLowerCase();
		log.info("The environment name is:" + envName);

		try {
			if (envName == null) {
				log.warn("the environment name is null :" + envName);
				fis = new FileInputStream("./src/test/resources/ConfigurationData/ConfigData.qa.properties");
			}

			else {
				switch (envName) {
				case "qa":
					fis = new FileInputStream("./src/test/resources/ConfigurationData/ConfigData.qa.properties");
					break;
				case "dev":
					fis = new FileInputStream("./src/test/resources/ConfigurationData/ConfigData.dev.properties");
					break;
				case "staging":
					fis = new FileInputStream("./src/test/resources/ConfigurationData/ConfigData.staging.properties");
					break;
				default:
					log.warn("The specified environment name is not valid");
					throw new FrameworkExceptions("===Invalid Environment===");
				}
			}
		}

		catch (Exception e) {
			e.getStackTrace();
		}

		try {
			prop.load(fis);
			bopts = new BrowserOptions(prop);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static File captureScreenshotFile() {
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		log.info(
				"From class [DriverManager] & method [captureScreenshotFile] The screenshot has initialized and returned");
		return ts.getScreenshotAs(OutputType.FILE);
	}

	public void init_remoteDriver(String browserName) {
		try {
			switch (browserName) {

			case "chrome":
				ltDriver.set(new RemoteWebDriver(new URL(prop.getProperty("hubUrl")), bopts.getChromeOptions()));
				break;
			case "firefox":
				ltDriver.set(new RemoteWebDriver(new URL(prop.getProperty("hubUrl")), bopts.getFirefoxOptions()));
				break;
			case "edge":
				ltDriver.set(new RemoteWebDriver(new URL(prop.getProperty("hubUrl")), bopts.getEdgeOptions()));
				break;
			default:
				log.error("Please supply the browser name for selenium grid");
				break;

			}
		} catch (Exception e) {

		}

	}

//	public Properties initProperty() {
//	    try {
//	        FileInputStream fis =
//	                new FileInputStream(I_ApplicationConstantValues.PROPERTYFILEPATH);
//
//	        prop = new Properties();
//	        prop.load(fis);
//	        bopts = new BrowserOptions(prop);
//
//	        log.info("From class [DriverManager] & method [initProperty] The property file has been initialized with proper location");
//	    } catch (Exception e) {
//	        log.info("From class [DriverManager] & method [initProperty] The property file is not initialized");
//
//	        throw new FrameworkExceptions(
//	                "===[DriverManager] - Could not initiate the property file / incorrect file path==="
//	        );
//	    }
//
//	    log.info("From class [DriverManager] & method [initProperty] The property file is initialized and returned");
//	    return prop;
//	}

}