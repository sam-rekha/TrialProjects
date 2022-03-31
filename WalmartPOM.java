package seleniumExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WalmartPOM {
	WebDriver driver;
	@FindBy(id="firstName")WebElement FName;
	@FindBy(xpath="//*[@id=\"lastName\"]")WebElement LName;
	@FindBy(id="phoneNumber")WebElement Phno;
	@FindBy(id="email")WebElement email;
	@FindBy(id="password")WebElement pwd;
	@FindBy(id="TAndC")WebElement chk;
	@FindBy(xpath="//*[@id=\"create-account-form\"]/div/div[9]/button")WebElement button;
	
	
	public WalmartPOM(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void typeFName(String fname) {
		FName.sendKeys(fname);
	}
	public void typeLName(String lname) {
		LName.sendKeys(lname);
	}
	public void typePhno(String pno) {
		Phno.sendKeys(pno);
	}
	public void typeemail(String femail) {
		email.sendKeys(femail);
	}
	public void typepwd(String pwds) {
		pwd.sendKeys(pwds);
	}
	public void chkbox() {
		chk.click();
	}
	public void acctbtn() {
		button.click();
	}
}
