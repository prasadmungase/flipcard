package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class profilepage {
WebDriver driver;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageaddress;
	
	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement addaddress;
	
	@FindBy(xpath="//textarea[@tabindex='5']")
	private WebElement add1;
	
	@FindBy(xpath="//button[@tabindex='10']")
	private WebElement save;
	
	public profilepage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickonmanagment() {
		manageaddress.click();
	}
	public void manageaddress() {
		addaddress.click();}
		
		public void addresss(List<String> addressdata) {
			
			for (int i=1;i<=4;i++){
			driver.findElement(By.xpath("//input[@tabindex='"+i+"']")).sendKeys(addressdata.get(i-1));
			
		}
			add1.sendKeys(addressdata.get(4));
			save.click();
		}
		
}
