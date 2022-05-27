package testLayer;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pomPackage.YourAddress;

public class YourAddressTest extends BaseAmazonClass {
	YourAddress Addresslog;
	public YourAddressTest() {
	super();
	}
	@BeforeClass
	public void initsetup() {
	initiate();
	Addresslog=new YourAddress();
	
	//login - existing user
	driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[13]/div[2]/a[1]/span[1]")).click();
	String uname=prop.getProperty("username");
	driver.findElement(By.id("ap_email")).sendKeys(uname);
	driver.findElement(By.id("continue")).click();
	String pwd=prop.getProperty("password");
	driver.findElement(By.id("ap_password")).sendKeys(pwd);
	driver.findElement(By.id("signInSubmit")).click();
	}
	
    //click on Your Address tab
	@Test(priority=1)
	public void address() throws InterruptedException {
	
	Addresslog.clickbtn();
	}
	
	//add adress form
	@Test(priority=2)
	public void addAddress() throws InterruptedException {
		
		Addresslog.newaddress();
		}
	
	//fill the new address form
	@Test(priority=3)
	public void fillform() throws InterruptedException {
		
	Addresslog.addressform();
	}
	
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
