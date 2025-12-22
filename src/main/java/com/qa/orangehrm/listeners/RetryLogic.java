package com.qa.orangehrm.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
		private int count =0;//1,2,3
		static final private int maxtry = 3;
		
		public boolean retry(ITestResult result) {
			if(!result.isSuccess()) {
				if(count<maxtry) {
					count++;
					result.setStatus(result.FAILURE);
				return true;
				}
				else {
					result.setStatus(result.FAILURE);
				}
			}
			else {
				result.setStatus(result.SUCCESS);
			}
			return false;
		}
}
