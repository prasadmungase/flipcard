package baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass1 {
static WebDriver driver;
	
	public static  WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		if(driver == null) {
			//System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Gita Govind\\\\eclipse-workspace\\\\selenium_1\\\\driver\\\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		return driver;
	}
	public static void unloadDriver() {
		driver=null;
		}
}
