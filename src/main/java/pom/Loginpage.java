package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement emailID;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement loginBtn;
	
	
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	
	public void enterEmailID() {
		emailID.sendKeys("akshaynarha1541@gmail.com");
	}
	
	public void enterPassword() {
		password.sendKeys("Akshay123");
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	

}
