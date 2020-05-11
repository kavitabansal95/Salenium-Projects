package newpro1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class search extends baseclass {
	
	
	
	@BeforeClass
	public void prereq() {
		baseclass.initbrowser();
	}
	
	@AfterClass
	public void wrapup() {
	   driver.quit();
	}
	
	@Test(priority=1)
	public void searchamazon() {
		driver.findElement(By.id("searchDropdownBox")).click();
		
		Select sel = new Select(driver.findElement(By.id("searchDropdownBox")));
		sel.selectByVisibleText("Amazon Pantry");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("pul");
		List<WebElement> list =driver.findElements(By.xpath("//div[@id='suggestions']//div[@class='s-suggestion']"));
		System.out.println(list.size());  
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("pulse candy")){
				list.get(i).click();
				break;
			}}}
	@Test(priority=2)
	public void candyshopping() {
		WebElement moreobj = driver.findElement(By.xpath("//a[@class='a-size-base a-link-normal s-no-hover']"));
	    System.out.println(moreobj.getText());
	    moreobj.click();
		baseclass.pageload();
		WebElement shop1= driver.findElement(By.linkText("Dark Fantasy Choco Fills, 300g"));  //shop1= dark fantacy 
		Actions act = new Actions(driver);
		act.moveToElement(shop1);
		act.perform();
	//	baseclass.pageload();
		baseclass.currentwindow();
		shop1.click();     //pick dark fantacy biscuit
        baseclass.newwindow();
        driver.findElement(By.xpath("//button[@id='a-autoid-8-announce']")).click();
        driver.findElement(By.linkText("following cities")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='unified_widget rcmBody']")).getText());
        driver.close();
        driver.switchTo().window(winHandleBefore);
        baseclass.pageload();
        }
	
	
	
	    @Test(priority=3)
	    @Parameters({"url", "pass"})
		public void flight(String url, String pass) {
		driver.findElement(By.id("nav-hamburger-menu")).click();
		List<WebElement> list1 =driver.findElements(By.xpath("//ul[@class='hmenu hmenu-visible']//li/descendant::a[@class='hmenu-item']"));
		list1.size();
		for (int j = 0; j < list1.size(); j++) {
			System.out.println(list1.get(j).getText());
			if (list1.get(j).getText().contains("Flight Tickets")) {
				list1.get(j).click();
				break;
				}}
			baseclass.pageload();
			System.out.println(driver.getTitle());
			driver.findElement(By.id("ap_email")).sendKeys(url);
			driver.findElement(By.id("ap_password")).sendKeys(pass);
			driver.findElement(By.id("signInSubmit")).click();
			
			
		
		
	}
	

}
