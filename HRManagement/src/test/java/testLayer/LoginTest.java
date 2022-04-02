package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseHRMClass;
import POMPackage.LoginPOM;
import testData.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	LoginPOM log;
	public LoginTest() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiate();
		log=new LoginPOM();
	}
	@DataProvider
	public Object[][] Details(){
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
	}
	@Test(priority=2, dataProvider="Details")
	public void Login(String name, String pwd) throws InterruptedException {
		log.typeName(name);
		log.typepwd(pwd);
		Thread.sleep(3000);
		//log.clickbtn();
	}
	@Test(priority=1)
	public void Title() {
		String actual=log.verify();
		Assert.assertEquals(actual, "OrangeHRM");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
