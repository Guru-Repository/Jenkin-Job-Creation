//package com.qa.orangehrm.diverfactory;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.safari.SafariDriver;
//
//import com.qa.orangehrm.apperrormsg.ApplicationErrorMsg;
//import com.qa.orangehrmexceptions.FrameworkExceptions;
//
//public class DriverManager {
//	private BrowserOptions bopts;
//	private Properties prop;
//	private static final Logger log = LogManager.getLogger(DriverManager.class);
//	public static ThreadLocal<WebDriver> ltDriver = new ThreadLocal<WebDriver>();
//
//	public WebDriver browserInit(String browserName) {
//		log.info("From class [DriverManager] & method [browserInit] The initialized browser is :" + browserName);
//		switch (browserName.toLowerCase().trim()) {
//		case "chrome":
//			ltDriver.set(new ChromeDriver(bopts.getChromeOptions()));
//			break;
//		case "firefox":
//			ltDriver.set(new FirefoxDriver(bopts.getFirefoxOptions()));
//			break;
//		case "edge":
//			ltDriver.set(new EdgeDriver(bopts.getEdgeOptions()));
//			break;
//		case "ie":
//			ltDriver.set(new InternetExplorerDriver(bopts.getIEOptions()));
//			break;
//		case "safari":
//			ltDriver.set(new SafariDriver());
//			break;
//		default:
//			System.out.println(ApplicationErrorMsg.INVALID_BROWSER_MSG);
//			throw new FrameworkExceptions("===Invalid Browsername===");
//		}
//		return getDriver();
//	}
//
//	public static WebDriver getDriver() {
//		log.info("From class [DriverManager] & method [getDriver] The localdriver has been returned");
//		return ltDriver.get();
//	}
//
//	/*
//	 * public Properties initProperty() { try { FileInputStream fis = new
//	 * FileInputStream(I_ApplicationConstantValues.PROPERTYFILEPATH); prop = new
//	 * Properties(); prop.load(fis); bopts = new BrowserOptions(prop); log.
//	 * info("From class [DriverManager] & method [initProperty] The porperty file  has been initialized with proper location"
//	 * ); } catch (Exception e) { log.
//	 * info("From class [DriverManager] & method [initProperty] The porperty file  is not initialized"
//	 * ); throw new
//	 * FrameworkExceptions("===[DriverManager] - Could not initiate the property file / incorrect file path==="
//	 * ); } log.
//	 * info("From class [DriverManager] & method [initProperty] The porperty file  is initialized and returned"
//	 * ); return prop; }
//	 */
//
//	public static File captureScreenshotFile() {
//		TakesScreenshot ts = (TakesScreenshot) getDriver();
//		log.info(
//				"From class [DriverManager] & method [captureScreenshotFile] The screenshot has initialized and returned");
//		return ts.getScreenshotAs(OutputType.FILE);
//	}
//
//	public Properties initProperty() {
//		prop = new Properties();
//
//		FileInputStream fis = null;
//
//		String envName = System.getProperty("env").trim().toLowerCase();
//
//		log.info("The envirom=nment name is : " + envName);
//
//		try {
//
//			if (envName == null) {
//				log.warn("The envirom=nment name is : " + envName);
//				fis = new FileInputStream("./src/test/resources/ConfigurationData/ConfigData.qa.properties");
//			}
//
//			else {
//				switch (envName) {
//				case "qa":
//					fis = new FileInputStream("./src/test/resources/ConfigurtionData/ConfigData.qa.properties");
//					break;
//
//				case "dev":
//					fis = new FileInputStream("./src/test/resources/ConfigurtionData/ConfigData.qa.properties");
//					break;
//
//				case "staging":
//					fis = new FileInputStream("./src/test/resources/ConfigurtionData/ConfigData.qa.properties");
//					break;
//
//				default:
//					log.warn("The specified environment name is not valid");
//					throw new FrameworkExceptions("===Invalid environment");
//				}
//			}
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//		try {
//			prop.load(fis);
//			bopts = new BrowserOptions(prop);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return prop;
//	}
//}

package com.qa.orangehrm.diverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

import com.qa.orangehrm.apperrormsg.ApplicationErrorMsg;
import com.qa.orangehrmexceptions.FrameworkExceptions;

public class DriverManager {

	private BrowserOptions bopts;
	private Properties prop;

	private static final Logger log = LogManager.getLogger(DriverManager.class);
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/* ================= Browser Initialization ================= */

	public WebDriver browserInit(String browserName) {

		if (browserName == null) {
			throw new FrameworkExceptions("Browser name cannot be null");
		}

		log.info("Initializing browser : {}", browserName);

		switch (browserName.toLowerCase().trim()) {

		case "chrome":
			tlDriver.set(new ChromeDriver(bopts.getChromeOptions()));
			break;

		case "firefox":
			tlDriver.set(new FirefoxDriver(bopts.getFirefoxOptions()));
			break;

		case "edge":
			tlDriver.set(new EdgeDriver(bopts.getEdgeOptions()));
			break;

		case "ie": // Deprecated – use only if required
			tlDriver.set(new InternetExplorerDriver(bopts.getIEOptions()));
			break;

		case "safari": // Works only on macOS
			tlDriver.set(new SafariDriver());
			break;

		default:
			log.error(ApplicationErrorMsg.INVALID_BROWSER_MSG);
			throw new FrameworkExceptions("=== Invalid Browser Name ===");
		}

		return getDriver();
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void quitDriver() {
		if (tlDriver.get() != null) {
			tlDriver.get().quit();
			tlDriver.remove();
		}
	}

	/* ================= Screenshot ================= */

	public static File captureScreenshotFile() {
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		log.info("Screenshot captured successfully");
		return ts.getScreenshotAs(OutputType.FILE);
	}

	/* ================= Property Initialization ================= */

//	public Properties initProperty() {
//
//		prop = new Properties();
//		FileInputStream fis;
//
//		String envName = System.getProperty("env");
//
//		if (envName == null) {
//			envName = "qa"; // default environment
//		}
//
//		envName = envName.toLowerCase().trim();
//		log.info("Environment selected : {}", envName);
//
//		try {
//			switch (envName) {
//
//			case "qa":
//				fis = new FileInputStream(
//						"./src/test/resources/ConfigurationData/ConfigData.qa.properties");
//				break;
//
//			case "dev":
//				fis = new FileInputStream(
//						"./src/test/resources/ConfigurationData/ConfigData.dev.properties");
//				break;
//
//			case "staging":
//				fis = new FileInputStream(
//						"./src/test/resources/ConfigurationData/ConfigData.staging.properties");
//				break;
//
//			default:
//				throw new FrameworkExceptions("=== Invalid environment name ===");
//			}
//
//			prop.load(fis);
//			bopts = new BrowserOptions(prop);
//
//		} catch (IOException e) {
//			log.error("Failed to load property file", e);
//			throw new FrameworkExceptions("=== Property file loading failed ===");
//		}
//
//		return prop;
//	}

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

					throw new FrameworkExceptions("===Invalid environment");

				}

			}

		} catch (Exception e) {

			e.getStackTrace();

		}

		try {

			prop.load(fis);

			bopts = new BrowserOptions(prop);

		} catch (IOException e) {

			e.printStackTrace();

		}

		return prop;

	}
}
