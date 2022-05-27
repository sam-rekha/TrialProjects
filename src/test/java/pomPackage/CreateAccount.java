package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;

public class CreateAccount extends BaseAmazonClass{
	@FindBy(id="ap_email") WebElement UserName;
	@FindBy(id="continue") WebElement Continue1;
	@FindBy(id="ap_password")WebElement Password;
	@FindBy(id="signInSubmit")WebElement SignIn;
	@FindBy(xpath="//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[13]/div[2]/a[1]/span[1]")WebElement Login;	
	@FindBy(id="nav-link-accountList-nav-line-1") WebElement Hello;
	
	public CreateAccount() {
		PageFactory.initElements(driver,this);
	}
	
	public void typeName(String name) {
		UserName.sendKeys(name);
	}
	
	public void typepwd(String pwd) {
		Password.sendKeys(pwd);
	}
	
	public void clickbtn() {
		Login.click();
}
	public void clickbtn1() {
		Continue1.click();
}
	public void clickbtn2() {
		SignIn.click();
}
	public String readUsername() {
		String name= Hello.getText();
		System.out.println(name);
		return name;
			}
	public String verify() {
		return driver.getTitle();
	}
}