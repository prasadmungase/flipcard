package pom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Untilclass.untilclass;

public class Homepage extends untilclass {
	WebDriver driver;
	
	
	@FindBy(xpath="//div[text()='Akshay']")
	private WebElement profileName;
	
	@FindBy(xpath="//input[@name='q']")
	private WebElement searchField;
	
	@FindBy(xpath="(//div[@class='_2kHMtA'])[1]")
	private WebElement firstProduct;
	
	
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private List<WebElement> productPriceElementList;
	
	@FindBy(xpath="//li[@class='_2NOVgj']")
	private WebElement myprofile;
	
	
	
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean checkProfileNameVisible() {
		
		try {
			waittaillelementpresent(driver, By.xpath("//div[text()='Akshay']"));
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	
	public void searchProduct() {
		searchField.sendKeys("realme");
		searchField.sendKeys(Keys.ENTER);
		waitTillElementPresent(driver, firstProduct);
	}
	
	
	public int getLowsetPrice() {
		List<Integer> productPriceList = new ArrayList<>();
		for(WebElement k : productPriceElementList) {
			productPriceList.add(Integer.parseInt(k.getText().replace("₹", "").replace(",", "")));	
		}
		Collections.sort(productPriceList);
		return productPriceList.get(0);
	}
	
	public void switchPage(int i) {
		
		driver.findElement(By.xpath("//a[@class='ge-49M' and text()='"+i+"']")).click();

		waittaillelementpresent(driver, By.xpath("//a[@class='ge-49M _2Kfbh8' and text()='"+i+"']"));
			
	}
	public boolean Clickonmyprofile() {
		Movetoelement(driver , profileName );
		myprofile.click();
		
		try {
		waittaillelementpresent(driver, By.xpath("///span[text()='Personal Information']"));
		}catch(Exception e) { return false;}
		return true;
		
	}
	
}
