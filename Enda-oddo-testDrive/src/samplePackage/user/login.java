package samplePackage.user;

import org.testng.annotations.Test;

import samplePackage.integration.testLink.TestLinkIntegration;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class login {
	
	protected WebDriver driver;
	
  @Test
  public void login() throws TestLinkAPIException {
	  try {
		  WebElement login = driver.findElement(By.id("login"));
	      WebElement password = driver.findElement(By.id("password"));
	      WebElement form = driver.findElement(By.className("oe_login_form"));
	      login.sendKeys("enda@g.com");
	      password.sendKeys("enda");
	      //submit the form
	      form.submit();
	      TestLinkIntegration.updateResult(samplePackage.Setting.TestCase.TEST_CASE_VALIDATELOGIN, null, TestLinkAPIResults.TEST_PASSED);
	  } catch (Exception e) {
		  TestLinkIntegration.updateResult(samplePackage.Setting.TestCase.TEST_CASE_VALIDATELOGIN, e.getMessage(), TestLinkAPIResults.TEST_FAILED);
	  }
  }
  @BeforeMethod
  public void beforeMethod() {
	  
		  System.setProperty("webdriver.gecko.driver","C:\\Users\\uid0918\\Desktop\\selenium need\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(samplePackage.Setting.Constante.TIME_OUT_WAITING, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get(samplePackage.Setting.Constante.LOGIN_URL);  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
