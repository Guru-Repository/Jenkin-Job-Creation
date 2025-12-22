package com.qa.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;

public class DashboardPageTest extends BaseTest {

	@BeforeClass
	public void dashboardPageSetUp() {
		dbp = lp.doLogin(prop.getProperty("usn"),prop.getProperty("psw"));
	}
	
	@Test(priority = Integer.MIN_VALUE)
	public void verifyDashBoardPage() {
		String actualHeading = dbp.verifyDashboardPageHeading();
		Assert.assertEquals(actualHeading,"Dashboard");
	}
	@Test(priority = 2)
	public void getCountOfMenuList() {
		int actualCount = dbp.verifyListCountOfMenuList();
		boolean res = (actualCount==12);
		Assert.assertTrue(res);
	}
	
	@Test(priority = 3)
	public void getMenuOptions() {
		dbp.fetchMenuListOptions();
	}
	
	@Test(priority = 4)
	public void selectMenu() {
		dbp.selectMenu("Leave");
	}
	
	@Test(priority = Integer.MAX_VALUE)
	public void doLogout() {
		dbp.logoutApplication();
	}
	
	
	
	
}
