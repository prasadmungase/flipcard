package testclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Untilclass.untilclass;
import baseclass.baseclass1;
import pom.Homepage;
import pom.Loginpage;

public class verifyusercanlogin {
	WebDriver driver;
	ExtentHtmlReporter htmlRepoter;
	ExtentReports reports;
	ExtentTest test;
	
	Loginpage lp;
	  Homepage hp;

	@BeforeClass
	public void beforeClass() {
		htmlRepoter =new ExtentHtmlReporter("ExtebtReports.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlRepoter);
		test = reports.createTest("verifyusercanlogin");
		
		driver = baseclass1.getDriver();
		
	}

	@BeforeMethod
	public void beforeMethod() {
		lp = new Loginpage(driver);
		hp = new Homepage(driver);
	}

	@Test
	public void VerifyUserLogin() {
		lp.enterEmailID();
		
		
		lp.enterPassword();
		lp.clickOnLoginBtn();
		boolean isProfileNameVisible = hp.checkProfileNameVisible();
		if(isProfileNameVisible) {
			System.out.println("Test case is passed");
		}else {
			System.out.println("Test is failed");
		}
	}


	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + "is pass");
		}else if(result.getStatus()==ITestResult.FAILURE) {
			String path =untilclass.getscreenshot(driver, result.getName());
			test.log(Status.FAIL, result.getName() + "is failed" , MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}else if(result.getStatus()==ITestResult.SKIP) {
			
			test.log(Status.FAIL, result.getName() + "is skipped"  );
			
		}
	}

	@AfterClass
	public void afterClass() {
		reports.flush();
	}
}
