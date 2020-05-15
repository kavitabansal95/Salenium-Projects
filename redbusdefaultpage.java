package RedbusTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class redbusdefaultpage extends BaseClass {
	
	@BeforeClass
	public void startbrowser() {
		BaseClass.setup();
	}
	
	@AfterClass
	public void stopbrowser() {
	//	driver.quit();
	}
	
	@Test(priority=1)
	public void launchbrowser() {
		BaseClass.LaunchBrowser();
	}

	
	@Test(priority=2)
	
    public void searchbuses() {
		driver.findElement(By.id("src")).sendKeys("jai");
		List<WebElement> srclist = driver.findElements(By.xpath("//ul[@class='autoFill']//li[contains(@select-id,'results')]"));
		srclist.size();
		for (int i = 0; i < srclist.size(); i++) {
			System.out.println(srclist.get(i).getText());
			if(srclist.get(i).getText().contains("Jaipur")) {
				srclist.get(i).click();
				break;
				}}
		BaseClass.waitaction();
		driver.findElement(By.id("dest")).sendKeys("ka");
		List<WebElement> destlist = driver.findElements(By.xpath("//ul[@class='autoFill']//li[contains(@select-id,'results')]"));
		destlist.size();
		for (int i = 0; i < srclist.size(); i++) {
			System.out.println(destlist.get(i).getText());
			if(destlist.get(i).getText().contains("Kannur")) {
				destlist.get(i).click();
				break;
				}}
		
	}
	
	
	
	//	js.executeScript("document.getElementsById('onward_cal').removeAttribute('readonly');", cal1);
	//	driver.findElement(By.xpath("(//input[@id='onward_cal'])[11]")).sendKeys("03-05-2019"); 
	
	
	
	@Test(priority=3)
	public void seldates() throws Exception {
	//	Thread.sleep(5000);
		String fromDate="20-May-2021";
		String toDate="20-Jun-2021";
		WebElement cal1 = driver.findElement(By.xpath("//input[@id='onward_cal']"));
	    WebElement cal2 = driver.findElement(By.xpath("//input[@id='return_cal']"));
	    BaseClass.setDateUsingJavaScriptInCalendar(driver, fromDate ,cal1);
		
        WebElement searchButton=	driver.findElement(By.id("search_btn"));
		BaseClass.elementwait(searchButton);
		searchButton.click();
	    
	}
		
	 
	     
		
		
		
		
		
		
		
		
		
		
		
		
	
			
	}


