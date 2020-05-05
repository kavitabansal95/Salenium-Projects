package newpro1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Amazon2  {
	
		WebDriver driver;
		Actions act;
		WebDriverWait wait;
		WebElement menu, signup;
		File scrfile;
		Select drpcontry ;
	
	
	
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
	 
	 
    @Test(priority=2)
     public void signin() throws InterruptedException {
    	 act= new Actions(driver);
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	 menu = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]/span"));
    	 signup = driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a"));
    	 act.moveToElement(menu).click(signup).build().perform();
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	 System.out.println(driver.getTitle());
    	 Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    	 Thread.sleep(5000);
    }
   
    
    @Test(priority=3)
         public void form() throws InterruptedException  {
      	 String crtacnthdr = driver.findElement(By.xpath("//*[@id=\"ap_register_form\"]/div/div/h1")).getText();
      	 
      	  Assert.assertEquals(crtacnthdr, "Create Account");
    	  driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).sendKeys("Kavita Bansal");
    	  String defCon = driver.findElement(By.xpath("//*[@id=\"auth-country-picker-container\"]/span/span")).getText();
    	  Assert.assertEquals(defCon, "IN +91");
    	  Select drpcontry = new Select(driver.findElement(By.xpath("//*[@id=\"auth-country-picker\"]")));
    	  drpcontry.selectByIndex(11);
    	  driver.findElement(By.xpath("//*[@id=\"ap_phone_number\"]")).sendKeys("9800000000");
    	  driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("er.7bansal.kavita10@gmail.com");
    	  driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("9876543210");
    	  String note1= driver.findElement(By.xpath("//*[@id=\"ap_register_form\"]/div/div/div[4]/div/div[1]")).getText();
    	  String note2= driver.findElement(By.xpath("//*[@id=\"ap_register_form\"]/div/div/div[5]")).getText();
    	  System.out.println(note1 + note2);
    	  driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    	  
    	  Thread.sleep(5000);
	 }
      @Test(priority=4)
          public void OtpVerification() throws InterruptedException {
    	  Boolean OTPs = driver.getCurrentUrl().contains("forceMobileLayout");
    	  Assert.assertTrue(OTPs);
    	  driver.getTitle();
    	  Boolean OTPL1 = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[3]/div/h1")).isDisplayed();
    	  Assert.assertTrue(OTPL1);
    	  Boolean OTPL2 = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[3]/div/p[3]")).isDisplayed();
    	  Assert.assertTrue(OTPL2);
    	  String OTPnum = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[3]/div/p[3]/span")).getText();
    	  OTPnum.contains("9876543210");
    	  Boolean numchng = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[3]/div/p[3]/a")).isEnabled();
    	  Assert.assertTrue(numchng);
    	  Boolean resendBtn = driver.findElement(By.xpath("//*[@id=\"auth-resend-code-link\"]")).isEnabled();
    	  Assert.assertTrue(resendBtn);
    	  driver.findElement(By.xpath("//*[@id=\"auth-pv-enter-code\"]")).sendKeys("1234");
    	  Boolean OTPb = driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).isDisplayed();
    	  Assert.assertTrue(OTPb);
    	  driver.findElement(By.xpath("//*[@id=\"auth-verify-button\"]")).click();
    	  Thread.sleep(5000);
    	  
      }
      
      @Test(priority=5)
          public void ResendOTP() {
    	  driver.findElement(By.xpath("//*[@id=\"auth-resend-code-link\"]")).click();
    	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	  Boolean ResOTP = driver.getCurrentUrl().contains("forceMobileLayout");
    	  Assert.assertTrue(ResOTP);
    	  Boolean ResMsg = driver.findElement(By.xpath("//*[@id=\"auth-resend-code-succeeded\"]/span")).isDisplayed();
    	  Assert.assertTrue(ResMsg);
    	  Boolean ResSuc = driver.findElement(By.xpath("//*[@id=\"auth-pv-client-side-success-box\"]")).isDisplayed();
    	  Assert.assertTrue(ResSuc);
    	  Boolean ResTitle1 = driver.getTitle().contains("Amazon Phone Verification");
    	  Assert.assertTrue(ResTitle1);
    	  driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[3]/div/p[3]/a")).click();
    	  Boolean ResTitle = driver.getTitle().contains("Amazon Registration");
    	  Assert.assertTrue(ResTitle);
    	  
    	  
      }
      	  
    
    
    
	}
