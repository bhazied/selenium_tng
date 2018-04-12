package samplePackage.Dashboard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Discussion {
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	
  @Test
  public void discussion() throws InterruptedException {
	  
	  wait = new WebDriverWait(driver, samplePackage.Setting.Constante.TIME_OUT_WAITING);
	  if(driver.getCurrentUrl().equals(samplePackage.Setting.Constante.SELECTOR_URL)) {
		  driver.findElement(By.partialLinkText(samplePackage.Setting.Constante.DB_TEST)).click();
		  By loginForm = By.id("login");
		  wait.until(ExpectedConditions.presenceOfElementLocated(loginForm));
		  WebElement login = driver.findElement(By.id("login"));
	      WebElement password = driver.findElement(By.id("password"));
	      WebElement form = driver.findElement(By.className("oe_login_form"));
	      login.sendKeys("enda@g.com");
	      password.sendKeys("enda");
	      //submit the form
	      form.submit();
	  }
	  wait = new WebDriverWait(driver, samplePackage.Setting.Constante.TIME_OUT_WAITING);
	  By mainContainer = By.cssSelector("o_content");
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(mainContainer)));
	  System.out.print(driver.getCurrentUrl());
	  WebElement link = driver.findElement(By.xpath("/html/body/header/nav[1]/div/div[2]/ul/li[1]"));
	  link.click();
	  By content = By.cssSelector("o_mail_chat");
	  WebElement cont_mail = driver.findElement(content);
	  wait.until(ExpectedConditions.visibilityOf(cont_mail));
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\uid0918\\Desktop\\selenium need\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(samplePackage.Setting.Constante.TIME_OUT_WAITING, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(samplePackage.Setting.Constante.DISCUSSION_URL); 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
