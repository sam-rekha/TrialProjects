package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import basePackage.BaseAmazonClass;

public class YourAddress extends BaseAmazonClass {

	public YourAddress() {
		PageFactory.initElements(driver,this);
	}
	
	public void clickbtn() throws InterruptedException {
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"))).build().perform();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Your Account")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//h2[contains(text(),'Your Addresses')]")).click();
	
}
	
	public void newaddress() throws InterruptedException {
	
	driver.findElement(By.xpath("//*[@id=\"ya-myab-address-add-link\"]/div")).click();
	Thread.sleep(3000);	
	}
	
	public void addressform() throws InterruptedException {
		
	driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys(prop.getProperty("fullname"));
	driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys(prop.getProperty("phone"));
	driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys(prop.getProperty("address"));
	driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys(prop.getProperty("city"));
	driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8")).click();
	driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys(prop.getProperty("postal"));
	driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("address-ui-widgets-original-address-block_id-input")).click();
	driver.findElement(By.xpath("//*[@id=\"a-autoid-2\"]/span/input")).click();
	}
}