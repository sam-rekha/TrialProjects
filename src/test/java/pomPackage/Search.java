package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import basePackage.BaseAmazonClass;

public class Search extends BaseAmazonClass{
	public Search() {
		PageFactory.initElements(driver,this);
	}
	
	public void productpagenum() {
	String totalprod=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]")).getText();
	String[] words=totalprod.split("\\s");
	System.out.println("split word:"+ words[0]);
	if (words[0]=="1-60")
		System.out.println("Each page has 60 products");
	else 
		System.out.println("Each page doesn't have 60 products");
	}
	
	public void filterpage() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"p_72/11192170011\"]/span/a/section")).click();
		System.out.println("Page Filtered");
		Thread.sleep(3000);
	}
	
	public void sortpage() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[2]/div/div/form")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText(prop.getProperty("sort"))).click();
		System.out.println("Page Sorted");
		Thread.sleep(3000);
	}
	
    public void sortfilterpage() {
		
		
	}
}
