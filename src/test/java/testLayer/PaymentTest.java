package testLayer;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pomPackage.Payment;

public class PaymentTest extends BaseAmazonClass {
	Payment paylog;
	public PaymentTest() {
	super();
	}
	
	@BeforeClass
	public void initsetup() {
	initiate();
	paylog=new Payment();
	
	//login - existing user
	driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[13]/div[2]/a[1]/span[1]")).click();
	String uname=prop.getProperty("username");
	driver.findElement(By.id("ap_email")).sendKeys(uname);
	driver.findElement(By.id("continue")).click();
	String pwd=prop.getProperty("password");
	driver.findElement(By.id("ap_password")).sendKeys(pwd);
	driver.findElement(By.id("signInSubmit")).click();
	}
	
    //click on Payment tab
	@Test(priority=1)
	public void paytab() throws InterruptedException {
	
		paylog.clickbtn();
	}
	
	//cards and account page
	@Test(priority=2)
	public void addpayment() throws InterruptedException {
		
		paylog.newpayment();
	}

	//enter new payment info
	@Test(priority=3)
	public void payform() {
		
		paylog.newpayform();
	}
	
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

	
}
