package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;

public class Payment extends BaseAmazonClass {

	public Payment() {
		PageFactory.initElements(driver,this);
	}
	
	public void clickbtn() throws InterruptedException {
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"))).build().perform();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Your Account")).click();
	Thread.sleep(3000);
	
}
	
	public void newpayment() throws InterruptedException {
	
	driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[2]/a/div/div/div/div[2]/div/span")).click();
	driver.findElement(By.linkText("Add a payment method")).click();
	driver.findElement(By.linkText("Add a credit or debit card")).click();
	
	driver.findElement(By.id("a-popover-1")).click();
	Thread.sleep(3000);	
	}

	public void newpayform() {
	driver.findElement(By.id("\"a-popover-1\"")).click();
	driver.switchTo().alert();
	driver.findElement(By.id("pp-rN2Q4E-15")).sendKeys(prop.getProperty("cardnum"));
	driver.findElement(By.id("pp-rN2Q4E-17")).sendKeys(prop.getProperty("nameoncard"));
	driver.findElement(By.id("pp-rN2Q4E-18")).click();
	driver.findElement(By.id("pp-rN2Q4E-18_4")).click();
	driver.findElement(By.id("pp-rN2Q4E-20")).click();
	driver.findElement(By.linkText("2024")).click();
	driver.findElement(By.linkText("Add your card")).click();
	}


}

