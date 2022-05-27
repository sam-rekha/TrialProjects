package testLayer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pomPackage.Search;
import pomPackage.ShoppingCart;

public class SearchTest extends BaseAmazonClass {
	ShoppingCart Shoplog;
	Search prodsearch;
	public SearchTest() {
	super();
	}
	@BeforeClass
	public void initsetup() {
	initiate();
	Shoplog=new ShoppingCart();
	prodsearch=new Search();
	}
	
	//search for a product
	@Test(priority=1)
	public void search() throws InterruptedException {
			
	Shoplog.search();
	}
	
	// check if product/page is 60
	@Test(priority=2)
	public void productpage()
	{
	prodsearch.productpagenum();
	}
	
	//check filter
	@Test(priority=3)
	public void filter() throws InterruptedException
	{
	prodsearch.filterpage();
	}
	
	//check sort
	@Test(priority=4)
	public void sort() throws InterruptedException
	{
	prodsearch.sortpage();
	}
	
	//check sortfilter
	@Test(priority=5)
	public void sortfilterpage()
	{
	prodsearch.sortfilterpage();
	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
