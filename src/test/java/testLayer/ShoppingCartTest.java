package testLayer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePackage.BaseAmazonClass;
import pomPackage.ShoppingCart;

public class ShoppingCartTest extends BaseAmazonClass {
	ShoppingCart Shoplog;
	public ShoppingCartTest() {
	super();
	}
	
	@BeforeClass
	public void initsetup() {
	initiate();
	Shoplog=new ShoppingCart();
	}
	//search for a product
	@Test(priority=1)
	public void search() throws InterruptedException {
		
		Shoplog.search();
	}
	//add a product to the shopping cart
	@Test(priority=2)
	public void addproduct() throws InterruptedException{
		
		Shoplog.addcart();
	}
	//remove all products from the shopping cart
	@Test(priority=5)
	public void removeproduct() throws InterruptedException{
		
		Shoplog.removecart();
	}
	//increase product quantity 
	@Test(priority=3)
	public void increaseproduct() throws InterruptedException{
		
	Shoplog.increasecart();
	}
	//decrease product quantity 
	@Test(priority=4)
	public void decreaseproduct() throws InterruptedException{
	Shoplog.decreasecart();
}
	@AfterClass
	public void close() throws InterruptedException {
	Thread.sleep(5000);
	driver.close();
	}
}