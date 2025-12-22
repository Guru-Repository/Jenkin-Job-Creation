package com.qa.orangehrm.diverfactory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserOptions {
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	private InternetExplorerOptions io;
	private Properties prop;
	
	public BrowserOptions(Properties prop) {
		this.prop=prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
		co.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
		co.addArguments("--incognito");
		}
		return co;
	}
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			fo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			fo.addArguments("--incognito");
		}
		return fo;
	}
	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			eo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			eo.addArguments("--incognito");
		}
		return eo;
	}
	public InternetExplorerOptions getIEOptions() {
		io = new InternetExplorerOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
		io.addCommandSwitches("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
		io.addCommandSwitches("--incognito");
		}
		return io;
	}
}
