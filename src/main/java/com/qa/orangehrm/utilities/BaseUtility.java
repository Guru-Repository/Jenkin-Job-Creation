package com.qa.orangehrm.utilities;

import org.openqa.selenium.WebDriver;

public abstract class BaseUtility {
		protected  WebDriver driver;
		public BaseUtility(WebDriver driver) {
			this.driver=driver;
		}
}
