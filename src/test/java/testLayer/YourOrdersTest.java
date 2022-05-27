package testLayer;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePackage.BaseAmazonClass;
import pomPackage.YourOrders;

public class YourOrdersTest extends BaseAmazonClass {
	YourOrders Orderslog;
	public YourOrdersTest() {
	super();
	}
	@BeforeClass
	public void initsetup() {
	initiate();
	Orderslog=new YourOrders();
	//login - existing user
	driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[13]/div[2]/a[1]/span[1]")).click();
	String uname=prop.getProperty("username");
	driver.findElement(By.id("ap_email")).sendKeys(uname);
	driver.findElement(By.id("continue")).click();
	String pwd=prop.getProperty("password");
	driver.findElement(By.id("ap_password")).sendKeys(pwd);
	driver.findElement(By.id("signInSubmit")).click();
	}
	
    //click on Your Orders tab
	@Test(priority=1)
	public void orders() throws InterruptedException {
			
	Orderslog.clickbtn();
	}
	
	//Buy Again Tab
	@Test(priority=2)
	public void orderagain() throws InterruptedException {
			
	Orderslog.buyagain();
	}
	
	//Not yet shipped tab
	@Test(priority=3)
	public void ordership() throws InterruptedException {
			
	Orderslog.notshipped();
	}
	
	//Cancelled order
	@Test(priority=4)
	public void cancelledorder() throws InterruptedException {
			
	Orderslog.cancelorder();
	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
