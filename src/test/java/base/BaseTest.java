package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	
	public static FileReader fr1;
	public static FileReader fr; 
	
	@BeforeMethod
	public void setup() throws IOException {
		
		if(driver==null) {
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			
			prop.load(fr);
			prop.load(fr1);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); //base
			driver = new ChromeDriver(); //base
			driver.get(prop.getProperty("testurl")); //properties
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup(); //base
			driver = new FirefoxDriver(); //base
			driver.get(prop.getProperty("testurl")); //properties
			}
	}

	@AfterMethod
	public void tearDown() {
		
		driver.close();
		System.out.println("Successfully completed Base");
	}
}
