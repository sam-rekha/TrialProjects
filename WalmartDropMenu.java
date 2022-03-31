package seleniumExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WalmartDropMenu {
	WebDriver driver;
	@BeforeSuite
	//set driver properties
	public void setdriver() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	}
	@BeforeTest
	//Open walmart.ca
	public void initial1() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get("https://www.walmart.ca/en");
		driver.manage().window().maximize();
	}
	@DataProvider(name="getdata")
	public Object[][] search(){
		return new Object[][] {{"mouse"},{"laptop"},{"tv"},{"xbox"}};
	}
	
	@Test(dataProvider="getdata")
	public void search(String Keywords) throws InterruptedException {
		
		//driver.findElement(By.xpath("//*[@id=\"departments-button\"]/div")).click();
		driver.findElement(By.id("search-form-input")).sendKeys(Keywords);	
		Thread.sleep(2000);	
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]/div/form/div/button[2]")).click();
	
	}
}
