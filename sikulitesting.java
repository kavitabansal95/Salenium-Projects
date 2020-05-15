package sikuli1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class sikulitesting {

	public static void main(String[] args) throws FindFailed {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "/Users/kbansal/Documents/Salenium/RedBus/redbusdoc/chromedriver");
	    WebDriver driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		driver.get("https://www.youtube.com/watch?v=VdL8eKb4yAc");
		
		Screen Sc = new Screen();
		
		Pattern hin = new Pattern("/Users/kbansal/Desktop/YT_play.png");
		Sc.wait(hin,600);
		Sc.doubleClick();
		
		
		Pattern pau = new Pattern("/Users/kbansal/Desktop/YT_pause.png");
		Sc.wait(pau,600);
		Sc.click();
		
		Pattern play = new Pattern("/Users/kbansal/Desktop/YT_play.png");
		Sc.wait(play,600);
		Sc.click();
		
		
		Pattern skip = new Pattern("/Users/kbansal/Desktop/YT_skin.png");
		Sc.wait(skip,600);
		Sc.click();
		
		
		
	}

}
