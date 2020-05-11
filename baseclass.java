package newpro1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class baseclass {
	static WebDriver driver; 
	 String url;
	 String pass;
	static String winHandleBefore;
	
	public static void initbrowser(){
		System.setProperty("webdriver.chrome.driver", "/Users/kbansal/Documents/Salenium/newpro1/file/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	
	
	public static void login(){
	    driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	 
	public static void pageload() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void currentwindow() {
		winHandleBefore = driver.getWindowHandle();
	}
    
	public static void newwindow() {
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}}
	
	
	
}
