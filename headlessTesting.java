package headless;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class headlessTesting {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/kbansal/Documents/Salenium/RedBus/redbusdoc/chromedriver");
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("window-size=1400,800");
		 options.addArguments("headless");
		 
		// TODO Auto-generated method stub
		
	    WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.get("https://www.idiva.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String Title = driver.getTitle();
		System.out.println(Title);
		Actions act = new Actions(driver);
		List<WebElement> Relations = driver.findElements(By.xpath("//a[@class='list-name']"));
		for (int i = 0; i < Relations.size(); i++) {
			System.out.println(Relations.get(i).getText());
		if (Relations.get(i).getText().contains("Beauty")) {
			act.moveToElement(Relations.get(i)).build().perform();
			Thread.sleep(3000);
         }	}
		
		
	//	driver.quit();
		
		
		
		
		
		
		
		
		
	}

}
