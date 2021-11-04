package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class keyswords {

	static WebDriver driver;
	static FileInputStream file;
	static Properties prop;
	
	
	public void openbrowser() throws Exception {
		
		try {
			file= new FileInputStream("C:\\Users\\win10\\eclipse-workspace\\Crmkeys\\src\\main\\java\\objectrepo\\objextrepository.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		prop.load(file);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\Crmkeys\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}


	public void navigate(String date) {
    driver.get(date);		
	}


	public void click(String objectname) {
		driver.findElement(By.xpath(prop.getProperty(objectname))).click();
		}


	public void input(String objectname, String date) {
		driver.findElement(By.xpath(prop.getProperty(objectname))).sendKeys(date);

		
	}


	public void refresh() throws Exception {
		driver.navigate().refresh();
		Thread.sleep(6000);
		
	}
	


}
