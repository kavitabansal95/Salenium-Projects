package RedbusTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	static WebDriver driver;
	static WebElement element;
	 public static void setup(){
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 
			System.setProperty("webdriver.chrome.driver", "/Users/kbansal/Documents/Salenium/RedBus/redbusdoc/chromedriver");
		    driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			//driver.manage().window().maximize();
		 }
	
	 public static void LaunchBrowser() {
			driver.get("https://www.redbus.in/");
			driver.manage().window().fullscreen();
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String Title = driver.getTitle();
			System.out.println(Title);
	 	}
	 
	public static void waitaction() {
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	public static void elementwait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public static void selectDate(WebElement element, String dateVal){
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",element);
		 }	
	public static void setDateUsingJavaScriptInCalendar(WebDriver driver, String value, WebElement element)
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		
		jse.executeScript("arguments[0].setAttribute('value','"+value+"');", element);
	}
	
	
	
}