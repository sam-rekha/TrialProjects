package POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseHRMClass;

public class LoginPOM extends BaseHRMClass{
	@FindBy(css="#txtUsername") WebElement UserName;
	@FindBy(id="txtPassword")WebElement Password;
	@FindBy(id="btnLogin")WebElement Login;	
	
	
	public LoginPOM() {
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
	public String verify() {
		return driver.getTitle();
	}
}