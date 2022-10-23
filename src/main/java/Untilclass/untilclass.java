package Untilclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


	public class untilclass {
		  public static void waittaillelementpresent(WebDriver driver ,By element) {
			  WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		  }

		public static void waitTillElementPresent(WebDriver driver, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		public static void Movetoelement(WebDriver driver , WebElement element) {

		   Actions act = new Actions(driver);
		   act.moveToElement(element).perform();
			
		}
		public static  String getscreenshot(WebDriver driver , String methodname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			String path = methodname + ".png";
			File dest = new File (path);
			FileHandler.copy(source, dest);
			
			return path;
		}
		
		public static void clickbyjava(WebDriver driver ,WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("argument[0].click();", element );
		}
}
