package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseAmazonClass;

public class ShoppingCart extends BaseAmazonClass{
	public ShoppingCart() {
		PageFactory.initElements(driver,this);
	}
	public void search() throws InterruptedException {
	driver.findElement(By.id("twotabsearchtextbox")).clear();
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(prop.getProperty("searchkeyword"));	
	driver.findElement(By.id("nav-search-submit-button")).click();
    Thread.sleep(2000);
	}
	
	public void addcart() throws InterruptedException {
	Thread.sleep(3000);	
	driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[1]/span/a/div")).click();
	driver.findElement(By.id("add-to-cart-button")).click();
	System.out.println("Added to cart successfully");
	}
	public void removecart() throws InterruptedException {
		Select quantity= new Select(driver.findElement(By.id("quantity")));
		quantity.selectByIndex(0);
		System.out.println("Your cart is empty");
		Thread.sleep(3000);
				}
	public void increasecart() throws InterruptedException {
	driver.findElement(By.xpath("//a[contains(text(),'Go to cart')]")).click();
	Select quantity= new Select(driver.findElement(By.id("quantity")));
	quantity.selectByIndex(3);
	System.out.println("Quantity Increased Successfully");
	Thread.sleep(3000);	
	}
	public void decreasecart() throws InterruptedException {
	Select quantity= new Select(driver.findElement(By.id("quantity")));
	quantity.selectByIndex(1);
	System.out.println("Quantity decreased Successfully");
	Thread.sleep(3000);		
		
	}
}

