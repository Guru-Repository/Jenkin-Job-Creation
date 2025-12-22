package com.qa.orangehrm.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.orangehrm.diverfactory.DriverManager;

import io.qameta.allure.Attachment;

public class AllureListenerUtility implements ITestListener{
	
	public String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] getScreenshotBytes(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "{0}", type = "text/plain")
	public String getTextLog(String msg) {
		return msg;
	}
	
	@Attachment(value = "{0}", type = "text/html")
	public String getHtmlLog(String html) {
		return html;
	}
	
	
	
	//before each testng.xml suite tag
	public void onStart(ITestContext context){
		System.out.println("I am here before suite execution :"+context.getName());
	}
	//after each testng.xml suite tag
	public void onFinish(ITestContext context) {
		System.out.println("I am here after suite execution :"+context.getName());
	}
	
	//It will execute before execution of each test method
	public void onTestStart(ITestResult result) {
		System.out.println("I am here on onTestStart execution method :"+result.getName());
	}

	//It will execute only if execution of each test method status is pass
	public void onTestSuccess(ITestResult result) {
		System.out.println("I am here on onTestSuccess execution method :"+result.getName());
	}
	
	//It will execute only if execution of each test method status is fail
	public void onTestFailure(ITestResult result) {
		System.out.println("I am here on onTestFailure execution method :"+result.getName());
		if(DriverManager.getDriver() instanceof WebDriver) {
			getScreenshotBytes(DriverManager.getDriver());
			System.out.println("Screenshot captured for failure test method that is :"+getTestMethodName(result));
		}
		getTextLog(getTestMethodName(result)+" Failed and screenshot captured");
	}
	
	//It will execute only if execution of each test method status is skipped
	public void onTestSkipped(ITestResult result) {
		System.out.println("I am here on onTestSkipped execution method :"+result.getName());
	}
}





