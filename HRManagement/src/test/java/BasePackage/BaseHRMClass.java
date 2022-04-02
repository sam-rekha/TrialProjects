package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utility.TimeUtils;

public class BaseHRMClass {
	public static Properties prop=new Properties();
	public static WebDriver driver;
	

	//Step1- create constructor to read from config file
	public BaseHRMClass() {
		try {
			FileInputStream file=new FileInputStream("C:\\Users\\Ramesh\\eclipse-workspace\\HRManagement\\src\\test\\java\\EnvironmentVariables\\Config.properties");
			prop.load(file);
			System.out.println(file);
				} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException a) {
			a.printStackTrace();
		}}
	//Step 2 
	public static void initiate() {
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
		}
}
	

