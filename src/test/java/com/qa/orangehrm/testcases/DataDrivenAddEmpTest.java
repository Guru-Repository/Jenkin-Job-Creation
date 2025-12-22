package com.qa.orangehrm.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;
import com.qa.orangehrm.pagelayers.PIM_Page;

public class DataDrivenAddEmpTest extends BaseTest {

	@BeforeMethod
	public void setUp() {
		dbp = lp.doLogin(prop.getProperty("usn"),prop.getProperty("psw"));
	}
	@Test(dataProvider = "multipleUserData")
	public void getAddEmpPage(String fn,String mn,String ln) throws InterruptedException {
		 pim = (PIM_Page) dbp.selectMenu("PIM");
		 pim.clickOnAddEmp();
		 pim.addEmployeeDetails(fn, mn,ln);
		 dbp.logoutApplication();
	}
	@DataProvider(name = "multipleUserData")
	public String[][] multipleUserData() throws Exception {
		String [][] data = new String[3][3];
		data[0][0]="1FN";
		data[0][1]="1MN";
		data[0][2]="1LN";
		data[1][0]="2FN";
		data[1][1]="2MN";
		data[1][2]="2LN";
		data[2][0]="3FN";
		data[2][1]="3MN";
		data[2][2]="3LN";
		return data;
	}
}
