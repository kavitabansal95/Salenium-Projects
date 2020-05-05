
package newpro1;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazoneLogin  {
	
	WebDriver driver;
	Actions act;
	
	
	@BeforeClass
	 public void setup(){
			System.setProperty("webdriver.chrome.driver", "/Users/kbansal/Documents/Salenium/newpro1/file/chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			//driver.manage().window().maximize();
		 }
	
	@AfterClass
	 public void closebrowser() {
	 	//driver.quit();
	 	 
	  	 }  
	 
	 
	@Test(priority=1)
	 public void LaunchBrowser() {
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			String Title = driver.getTitle();
			System.out.println(Title);
 	 	}
	 
	
	@Test(priority=1)
	public void login() {
			Boolean dig = driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]")).isDisplayed();
			Assert.assertTrue(dig);
			driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a")).click();
			Boolean loginURL = driver.getCurrentUrl().contains("signin");
			Assert.assertTrue(loginURL);
			Boolean Logintitle = driver.getTitle().equals("Amazon Sign In");
			Assert.assertTrue(Logintitle);
			Assert.assertEquals(driver.findElement(By.className("a-spacing-small")).getText(), "Login");
			Assert.assertEquals(driver.findElement(By.className("a-form-label")).getText(), "Email or mobile phone number");
			driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("loginfortheday@gmail.com");
			//String mailId = driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).getText();
			driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
			driver.getCurrentUrl().equals("https://www.amazon.in/ap/signin");
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/div/span")).getText(), "loginfortheday@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"remember_me_learn_more_link\"]")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"a-popover-1\"]")).isDisplayed());
			driver.findElement(By.xpath("//*[@id=\"a-popover-1\"]/div/div[1]/button/i")).click();
			driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("loginfortheday");
			driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/form/div/div[2]/div/div/label/div/label/input")).click();
			driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"auth-warning-message-box\"]/div/h4")).getText(), "Important Message!");
	
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"auth-warning-message-box\"]/div/div/ul/li/span")).isDisplayed());
			driver.findElement(By.linkText("Change")).click();
			Assert.assertTrue(driver.getCurrentUrl().contains("signin?showRememberMe"));
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/h1")).getText(), "Login");
			
		}
	
	@Test(priority=2)
	public void loginbyMobileNo() {
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("9800000000");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElement(By.className("a-alert-heading")).getText(), "Incorrect phone number");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText(), "We cannot find an account with that mobile number");
		WebElement EmailMob = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
		EmailMob.clear();
		EmailMob.sendKeys("7597230725");
		
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.linkText("Forgot Password")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("forgotpassword"));
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/div/form/h1")).getText(), "Password assistance");
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("7597230720");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[2]")).isDisplayed());
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]")).isDisplayed());
		driver.navigate().back();
		driver.findElement(By.linkText("Customer Service")).click();
		
	}
	
}
