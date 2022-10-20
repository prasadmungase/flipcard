package testclasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.baseclass1;
import pom.Homepage;

public class Verifyusercanlowest {
	WebDriver driver;
	
	Homepage hp;
	
	@BeforeClass
	public void beforeClass() {
		driver = baseclass1.getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		hp = new Homepage(driver);
	}
	
	@Test()
	public void VerifyUserGetLowestPriceProduct() {
		hp.searchProduct();	
		
		for(int i=1; i<=5; i++) {
			
			if(i != 1) {
				hp.switchPage(i);
			}
			
			System.out.println(hp.getLowsetPrice());	
		}
		
		
	}
	
	
	@AfterMethod
	public void afterMethod() {
	
	}
	
	@AfterClass
	public void afterClass() {
		
		
	}
	

}

