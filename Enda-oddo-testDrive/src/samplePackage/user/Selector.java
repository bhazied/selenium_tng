package samplePackage.user;

import org.testng.annotations.Test;

import samplePackage.integration.testLink.TestLinkIntegration;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Selector {
	
	protected WebDriver driver;
	
  @Test
  public void main() throws TestLinkAPIException {
	  try {
		  driver.findElement(By.partialLinkText(samplePackage.Setting.Constante.DB_TEST)).click();
		  TestLinkIntegration.updateResult(samplePackage.Setting.TestCase.TEST_CASE_VALIDATESELECTOR, null, TestLinkAPIResults.TEST_PASSED);
	  } catch (Exception e) {
		  TestLinkIntegration.updateResult(samplePackage.Setting.TestCase.TEST_CASE_VALIDATESELECTOR, e.getMessage(), TestLinkAPIResults.TEST_FAILED);
	}
  }
  @BeforeTest
  public void beforeTest() {
	  //System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\uid0918\\Desktop\\testlinkfocuscomtn.crt");
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\uid0918\\Desktop\\selenium need\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  //driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(samplePackage.Setting.Constante.TIME_OUT_WAITING, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(samplePackage.Setting.Constante.SELECTOR_URL);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
