package seleniumExample;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WalmartAutomation {
SoftAssert obj;	
WebDriver driver;
	@BeforeSuite
	//set driver properties
	public void setdriver() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	}
	@BeforeTest
	//Open walmart.ca
	public void initial() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get("https://www.walmart.ca/en");
		driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	//Take Screenshot
	public void screenshot() throws IOException  {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile,new File("C://Users/Ramesh/Desktop/QA/screenshot.jpg"));
	}
	
	@Test(priority=1)
	//Check Title
	public void chkTitle() {
		String Title= driver.getTitle();
		System.out.println("Title is " +Title);
		Assert.assertEquals(Title,"Online Shopping Canada: Everyday Low Prices at Walmart.ca!");
	}
	
	@Test(priority=3)
	public void walmartDisplay() {
	boolean ans=driver.findElement(By.id("walmartblue_Layer_1")).isDisplayed();
	System.out.println(ans);
	}
	
	@Test(priority=4)
	//Mouse Hover Action
	 public void mousehover() throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/div/div[2]/div[2]/div/div[2]/div/div[4]/div/span/a/div/span"))).build().perform();
		driver.findElement(By.linkText("Join now")).click();
		}
		@Test(priority=5)
		//Fill the form
		public void form() throws InterruptedException {
		WalmartPOM abc=new WalmartPOM(driver);
		abc.typeFName("Allen");
		abc.typeLName("Scott");
		abc.typePhno("9055656565");
		abc.typeemail("trial@gmail.com");
		abc.typepwd("allen123");
		abc.chkbox();
		abc.acctbtn();
		Thread.sleep(2000);
	}
	
	@AfterClass
	//Step 4: Close the browser
	public void closebrowser()  {
    driver.close();
    
}
}
