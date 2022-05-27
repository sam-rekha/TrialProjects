package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pomPackage.CreateAccount;


public class CreateAccountTest extends BaseAmazonClass {
	CreateAccount log;
	public CreateAccountTest() {
	super();
	}
	@BeforeClass
	public void initsetup() {
		initiate();
		log=new CreateAccount();
	}
	
    //Check 'Hello, Username'
	@Test(priority=2)
	public void Hello() throws InterruptedException {
	String Helloname=log.readUsername();
	Assert.assertEquals(Helloname, "Hello, Trial");	
	System.out.println("Hello, <username> Success");
	}
	
	//login - existing user
	@Test(priority=1)
	public void Title() {
		String actual=log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
		log.clickbtn();
		log.typeName(prop.getProperty("username"));
		log.clickbtn1();
		log.typepwd(prop.getProperty("password"));
		log.clickbtn2();
	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
