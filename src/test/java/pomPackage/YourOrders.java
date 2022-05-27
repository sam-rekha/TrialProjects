package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import basePackage.BaseAmazonClass;


public class YourOrders extends BaseAmazonClass {

	public YourOrders() {
		PageFactory.initElements(driver,this);
	}
	
	public void clickbtn() throws InterruptedException {
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"))).build().perform();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Your Orders")).click();
	Thread.sleep(3000);
	//driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
	
}
	public void buyagain() throws InterruptedException {
		
		driver.findElement(By.linkText("Buy Again")).click();
		Thread.sleep(3000);
	}
	
	public void cancelorder() throws InterruptedException {
	
		driver.findElement(By.linkText("Cancelled Orders")).click();
		Thread.sleep(3000);
	}
	
	public void notshipped() throws InterruptedException {
		driver.findElement(By.linkText("Not Yet Shipped")).click();
		Thread.sleep(3000);
	}
	
	
	
	
}




